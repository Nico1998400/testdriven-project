package com.example.testdrivenproject.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AppUser {
    @Column
    private String username;

    @Column
    private String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AppUser(){

    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser appUser)) return false;
        return username.equals(appUser.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
