package com.gabrielmeneguite.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    private boolean isAdm;

    private boolean isDeleted; // para exclusao logica

    public User(int id, String name, boolean isAdm) {
        this.id = id;
        this.name = name;
        this.isAdm = isAdm;
        this.isDeleted = false;
    }

    public User(int id, String name, boolean isAdm, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isAdm = isAdm;
        this.isDeleted = isDeleted;
    }

    public User() {
        this.name = "nome";
        this.isAdm = false;
        this.isDeleted = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdm() {
        return isAdm;
    }

    public void setAdm(boolean adm) {
        isAdm = adm;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}
