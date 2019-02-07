/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HttpSessionConfig {

    private static final Map<String, HttpSession> ACTIVE_SESSION = new HashMap<>();

    public Map<String, HttpSession> getActiveSessions() {
        return ACTIVE_SESSION;
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent hse) {
                ACTIVE_SESSION.put(hse.getSession().getId(), hse.getSession());
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent hse) {
                ACTIVE_SESSION.remove(hse.getSession().getId());
            }
        };
    }
} 