/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.service;

import com.juba13.identityhub.model.User;
import com.juba13.identityhub.repo.UserRepo;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarker
 */
@Service
public class UserService   {

    @Autowired
    UserRepo repo;

    
    public User add(User model) {
        model.setId(UUID.randomUUID());
        return repo.save(model);
    }

    public User update(User model) {
        return repo.save(model);
    }

    public List<User> list() {
        return repo.findAll();
    }
    
    public List<User> listActive() {
        return repo.findAllByActive(true);
    }

    public User get(UUID id) {
        return repo.findById(id).get();
    }

    
    public User changeState(UUID id, boolean active) {
        User user = repo.findById(id).get();
        user.setActive(active);
        return repo.save(user);
    }
}
