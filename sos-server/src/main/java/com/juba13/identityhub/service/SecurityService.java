/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.service;

import com.juba13.identityhub.HttpSessionConfig;
import static com.juba13.identityhub.KEY.USER;
import com.juba13.identityhub.model.App;
import com.juba13.identityhub.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
public class SecurityService {
    
     
    @Autowired
    HttpSessionConfig sessionConfig;


    @Value("${application.setup.master.username}")
    private String masterUserName;

    @Value("${application.setup.master.password}")
    private String masterPassword;

    private String SYSTEM_PRIVATE_KEY = "AJSASBAGUAHCSHGCSUBCHASTTDSCHSJBHDYSGDUASHD";

    public String getTempToken(App app, User user, String sessionId) {
        String token = Jwts.builder()
                .setId(sessionId)
                .setIssuer(app.getPublicKey())
                .setAudience(user.getEmail())
                .setIssuedAt(Calendar.getInstance().getTime())
                .setNotBefore(Calendar.getInstance().getTime())
                .signWith(SignatureAlgorithm.HS256, SYSTEM_PRIVATE_KEY)
                .compact();
        return token;
    }
    
    
    public Map getUserInfo(App app,String tempToken) {
        Map<String,Object> data=new HashMap<>();
        try {
            final Claims claims = Jwts.parser().setSigningKey(SYSTEM_PRIVATE_KEY).parseClaimsJws(tempToken).getBody();
         String sessionId=claims.getId();
         String userEmail=claims.getAudience();
         String appPublicKey=claims.getIssuer();
         HttpSession session=sessionConfig.getActiveSessions().get(sessionId);
         User user=(User)session.getAttribute(USER);
         data.put("STATUS", 1);
         data.put("USER_CODE", user.getCode());
         data.put("USER_NAME", user.getName());
         data.put("USER_EMAIL", user.getEmail());
        } catch (Exception e) {
            data=new HashMap<>();
            data.put("STATUS", 0);
        }
        return data;
    }

}
