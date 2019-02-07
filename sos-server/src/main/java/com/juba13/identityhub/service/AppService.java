/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.service;

import com.juba13.identityhub.model.App;
import com.juba13.identityhub.repo.AppRepo;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 *
 * @author juba
 */
@Service
public class AppService {

    @Autowired
    AppRepo repo;

    public App add(App model) {
        model.setId(UUID.randomUUID());
        return repo.save(model);
    }


    public App update(App model) {
         return repo.save(model);
    }

    
    public List<App> list() {
        return repo.findAll();
    }
    
    public List<App> list(boolean active) {
        return repo.findAllByActive(active);
    }
    
     public List<App> list(UUID userId,boolean active) {
         return repo.fetchApps(userId,active);
    }
     
     
    public App get(UUID appId,UUID userId) {
         return repo.fetchApp(appId,userId);
    }
     
    public boolean isEligible(UUID appId,UUID userId) {
        App app=repo.fetchApp(appId,userId);
        if(app!=null && app.isActive()) return  true;
        return false;
    }
     
     
     
     
     

    public App get(UUID id) {
       return repo.findById(id).get();
    }
    public App getByPublicKey(String publicKey) {
       return repo.findBypublicKey(publicKey);
    }

    public App changeState(UUID id, boolean active) {
        App  app=repo.findById(id).get();
        app.setActive(active);
        return repo.save(app);
    }

    
    
    
 public String getKey(String str){
        StringBuilder key= new StringBuilder( DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase());
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(key.toString().getBytes(StandardCharsets.UTF_8));
            key=new StringBuilder();
            for (byte b : hashInBytes) {
                key.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {}
      return key.toString().toUpperCase();
    }
    
    
   
    
}
