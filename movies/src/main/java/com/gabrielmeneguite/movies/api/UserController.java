package com.gabrielmeneguite.movies.api;


import com.gabrielmeneguite.movies.dao.UserDao;
import com.gabrielmeneguite.movies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "user") // This means URL's start with /user (after Application path)
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping(path = "new_user")
    public @ResponseBody void addNewUser (@RequestBody User user) { //adicao
        userDao.save(user);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<User> getAllUsers() { //listagem
        return userDao.findAll();
    }

    @DeleteMapping(path="/delete", params = "id")
    public @ResponseBody void deleteUser(@RequestParam("id") int id) { //exclusao
        Optional<User> op = userDao.findById(id);
        if(op != null && !op.get().isDeleted()){
            op.get().setDeleted(true);
            userDao.save(op.get());
        }
    }

//    @Query( value = "SELECT * FROM user u WHERE isAdm = false",
//            nativeQuery = true)
    @GetMapping(path = "user_normal")
    public @ResponseBody Iterable<User> getNonAdmUsers(){
            return userDao.findUserByIsAdmAndIsDeletedOrderByNameAsc(false, false);
    }
}
