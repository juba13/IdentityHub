/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.controller.setup;
import com.juba13.identityhub.model.Category;
import com.juba13.identityhub.service.AuthService;
import com.juba13.identityhub.service.CategoryService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "setup/category")
public class CategoryController {
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private CategoryService service;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons(Model model) {
            model.addAttribute("list", this.service.list());
            return "category-list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
            model.addAttribute("category", new Category());
            return "category-view";
    }
    
    @RequestMapping(value = "/edit/{id}",  method = RequestMethod.GET)
    public String edit(@PathVariable("id") UUID id, Model model){
       model.addAttribute("category",service.get(id));
       return "category-view";
    }
     
    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("category") Category category, Model model){
        try {
                if(category.getId() !=null) 
                {
                    this.service.update(category);
                }else{
                    this.service.add(category);
                }
		return "redirect:/setup/category/list";
        } catch (Exception e) {
             
             model.addAttribute("category",category);
             model.addAttribute("error_message",e.getMessage());
             return "category-view";
        }       
    }
    
    @RequestMapping(value = "/change-state/{id}/{active}",  method = RequestMethod.GET)
    public String changeState(@PathVariable("id") UUID id,@PathVariable("active") boolean active,Model model){		
        Category changeState = this.service.changeState(id,active);
        return "redirect:/setup/category/list";
    }
    
    @RequestMapping(value = "/test",  method = RequestMethod.GET)
    @ResponseBody
    public String test(){		
        return "test";
    }
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("USER", authService.getUser());
    }
}
