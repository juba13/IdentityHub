/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.controller.setup;

import com.juba13.identityhub.model.User;
import com.juba13.identityhub.service.AppService;
import com.juba13.identityhub.service.AuthService;
import com.juba13.identityhub.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "setup/user")
public class UserController  {
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserService service;
    
    @Autowired
    private AppService appService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("list", this.service.list());
        return "user-list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("apps", appService.list());
        return "user-view";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("user", service.get(id));
        model.addAttribute("apps", appService.list());
        return "user-view";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user, Model model) {
        try {
            if (user.getId() != null) {
                this.service.update(user);
            } else {
               
                
                this.service.add(user);
                
            }
            
            return "redirect:/setup/user/list";
        } catch (Exception e) {

             model.addAttribute("user", user);
             model.addAttribute("error_message",e.getMessage());
            return "user-view";
        }
    }

    @RequestMapping(value = "/change-state/{id}/{active}", method = RequestMethod.GET)
    public String changeState(@PathVariable("id") UUID id, @PathVariable("active") boolean active, Model model) {
        User changeState = this.service.changeState(id, active);
        return "redirect:/setup/user/list";
    }

}


//9c276f37-7868-44d7-961e-cd8bd4b87266
//4601bcbf-0663-4796-b9e8-cf2cde98f798