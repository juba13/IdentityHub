/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.controller;

import com.juba13.identityhub.HttpSessionConfig;
import static com.juba13.identityhub.KEY.USER;
import com.juba13.identityhub.model.App;
import com.juba13.identityhub.model.User;
import com.juba13.identityhub.service.AppService;
import com.juba13.identityhub.service.AuthService;
import com.juba13.identityhub.service.SecurityService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarker
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    HttpSession session;
    
   
    @Autowired
    AppService appService;

    @Autowired
    AuthService authService;
    
    
     @Autowired
     SecurityService  securityService;

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public ModelAndView index() {
        return new ModelAndView("redirect:/auth/login");
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public ModelAndView login(@RequestParam(name = "app_key", required = false) String appKey) {
        User user = authService.getUser();
        if (appKey != null) {
            App app = appService.getByPublicKey(appKey);
            if (app != null && app.isActive()) {
                if (user != null) {
                    if (appService.isEligible(app.getId(), user.getId())) {
                        return new ModelAndView("redirect:"+authService.getAppTempUrl(app,securityService.getTempToken(app, user, session.getId())));
                     //return new ModelAndView("redirects").addObject(APP_URL,authService.getAppTempUrl(app,session.getId()));
                    } else {
                        return new ModelAndView("redirect:/home");
                    }
                } else {
                    return new ModelAndView("login").addObject("app", app);
                }
            }
        } else if (user != null) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    public ModelAndView doLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(name = "keepme", required = false) boolean keepme,
            @RequestParam(name = "app_key", required = false) String appKey) {

        User user = authService.getUser(email, password);

        if (appKey != null) {

            App app = appService.getByPublicKey(appKey);
            if (app != null && app.isActive() && user != null && appService.isEligible(app.getId(), user.getId())) {
                session.setAttribute(USER, user);
                if (keepme) {
                    session.setMaxInactiveInterval(-1);
                }
                    return new ModelAndView("redirect:"+authService.getAppTempUrl(app,securityService.getTempToken(app, user, session.getId())));
               // return new ModelAndView("redirects").addObject(APP_URL,authService.getAppTempUrl(app,session.getId()));
            }
            return new ModelAndView("login").addObject("app", app).addObject("status", "Invalid username/password");

        } else {
            if (user != null) {
                session.setAttribute(USER, user);
                if (keepme) {
                    session.setMaxInactiveInterval(-1);
                }
                return new ModelAndView("redirect:/home");
            } else {
                return new ModelAndView("login").addObject("status", "Invalid username/password");
            }
        }
    }

    @RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
    public ModelAndView logout() {
        session.invalidate();
        return new ModelAndView("redirect:/auth/login");
    }
    
    
    @RequestMapping(value = {"/userinfo"}, method = {RequestMethod.GET})
    @ResponseBody
    public Map userinfo(@RequestParam("app_key") String appKey ,@RequestParam("temp_token") String temp_token) {
        App app = appService.getByPublicKey(appKey);
        return securityService.getUserInfo(app, temp_token);
    }
}
