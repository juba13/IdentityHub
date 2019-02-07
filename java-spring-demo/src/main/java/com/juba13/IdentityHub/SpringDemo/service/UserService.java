/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.IdentityHub.SpringDemo.service;

import com.juba13.IdentityHub.SpringDemo.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Map<String, User> USERS = new HashMap<>();

    public UserService() {
        loadUser();
    }

    public Map<String, User> getUSERS() {
        return USERS;
    }

    public User getUser(String email) {
        return USERS.get(email);
    }

    private void loadUser() {

        USERS.clear();
        USERS.put("jubayer@friendship.ngo", new User(1, "Md. Jubayer", "0715", "jubayer@friendship.ngo", "Assistant Manager- Application Development"));
        USERS.put("sarker@friendship.ngo", new User(2, "Shahadat Sarker", "1265", "sarker@friendship.ngo", "Senior Executive- Application Development"));
        USERS.put("imtiaz@friendship.ngo", new User(2, "Zakaria Imtiaz", "1018", "imtiaz@friendship.ngo", "Senior Executive- Application Development"));

    }
}
