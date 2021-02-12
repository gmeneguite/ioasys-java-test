package com.gabrielmeneguite.movies.dao;

import com.gabrielmeneguite.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findUserByIsAdmAndIsDeletedOrderByNameAsc(boolean isAdm, boolean isDeleted);
}
