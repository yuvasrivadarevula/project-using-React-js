package com.login.loginForm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class User {
    private String name;
    @Id
    private String ID;
    private String password;

    public User() {
    }

    public User(String name, String ID, String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


