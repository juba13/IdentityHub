/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.service;

import com.juba13.identityhub.model.App;
import com.juba13.identityhub.model.User;
import com.juba13.identityhub.repo.AppRepo;
import com.juba13.identityhub.repo.UserRepo;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *
 * @author juba
 */
@PropertySource(value = "classpath:application.properties")
@Service
public class AuthService {
 @Value("${application.setup.master.username}")
 private String masterUserName;
 
 @Value("${application.setup.master.password}")
 private String masterPassword;
 
 
 @Autowired
 UserRepo userRepo;
 
 @Autowired
 AppRepo appRepo;
    
 

 
@Autowired
HttpSession session;

public String getSessioId() {
    return session.getId();
}


public User getUser() {
    return (User) session.getAttribute("USER");
}




    public String getMasterUserName() {
        return masterUserName;
    }

    public String getMasterPassword() {
        return masterPassword;
    }
    
    
    
   public  User getUser(String email,String password){
       if(email.equals(masterUserName) && password.equals(password)){
          return  getMasterUser();
       } else{
         return userRepo.findByEmailAndPassword(email, password);
       }
    }
   
   private User getMasterUser(){
     User master =new User();
     master.setId(UUID.fromString("68566d83-345b-4546-96c9-389acc83a03c"));
     master.setEmail(masterUserName);
     master.setPassword(masterUserName);
     master.setName("Setup Master");
     master.setMaster(true);
     return master;
   
   }
    
     
   public String getAppTempUrl(App app ,String tempToken){
       return app.getAppUrl()+"?temp_token="+tempToken;
   }
}
