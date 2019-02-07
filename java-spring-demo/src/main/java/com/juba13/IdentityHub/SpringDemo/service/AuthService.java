/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.IdentityHub.SpringDemo.service;

import com.juba13.IdentityHub.SpringDemo.model.User;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource(value = "classpath:application.properties")
@Service
public class AuthService {
    
    @Value("${sso.auth.url}")
    private String authUrl;
    @Value("${sso.auth.appkey}")
    private String appKey;
    @Value("${sso.auth.userinfo.url}")
    private String authUserInfoUrl;
    

    @Autowired
    HttpSession session;

    public String getSessioId() {
        return session.getId();
    }

    public User getUser() {
        return (User) session.getAttribute("USER");
    }
    
    
    public String getAuthUrl() {
        return authUrl+"?app_key="+appKey;
    }
}
