/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.controller;
import com.juba13.identityhub.model.App;
import com.juba13.identityhub.model.User;
import com.juba13.identityhub.service.AppService;
import com.juba13.identityhub.service.AuthService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private AuthService authService;
    
    @Autowired
    private AppService appService;
    
    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public ModelAndView index() {
        return new ModelAndView("redirect:/home");
    }
    
    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET})
    public ModelAndView launcher() {
        
        User user = authService.getUser();
        if (user != null) {
            return user.isMaster()?  new ModelAndView("redirect:/setup/app/list").addObject("user",user)   : new ModelAndView("home").addObject("user",user).addObject("apps",appService.list(user.getId(), true));
        } else {
            return new ModelAndView("redirect:/auth/login");
        }
    }
}
