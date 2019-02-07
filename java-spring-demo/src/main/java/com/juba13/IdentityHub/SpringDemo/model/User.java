/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.IdentityHub.SpringDemo.model;

/**
 *
 * @author juba
 */
public class User {
    private long id;
    private String name;
    private String code;
    private String email;
    private String role;

    public User(long id, String name, String code, String email, String role) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.email = email;
        this.role = role;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", code=" + code + ", email=" + email + ", role=" + role + '}';
    }
}
