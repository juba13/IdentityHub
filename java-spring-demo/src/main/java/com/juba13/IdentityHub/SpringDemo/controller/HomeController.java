/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.IdentityHub.SpringDemo.controller;
import com.juba13.IdentityHub.SpringDemo.model.User;
import com.juba13.IdentityHub.SpringDemo.service.AuthService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private AuthService authService;
    
    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public ModelAndView index() {
        return new ModelAndView("redirect:/home");
    }
    
    
    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET})
    public ModelAndView home() {
        User user = authService.getUser();
        if (user != null) {
            return new ModelAndView("home").addObject("user",user);
        } else {
            return new ModelAndView("redirect:/login");
        }
    }
    
    
    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET})
    public ModelAndView home(Requ) {
        User user = authService.getUser();
        if (user != null) {
           return new ModelAndView("redirect:/home");
        } else {
           return new ModelAndView("redirect:"+authService.getAuthUrl());
        }
    }
    
    
    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public ModelAndView login() {
        User user = authService.getUser();
        if (user != null) {
           return new ModelAndView("redirect:/home");
        } else {
           return new ModelAndView("redirect:"+authService.getAuthUrl());
        }
    }
    
    
    
}
