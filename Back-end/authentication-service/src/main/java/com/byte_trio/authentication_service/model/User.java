package com.byte_trio.authentication_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String role;

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getRole() {return role;}

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return username + password + role;
    }
}
