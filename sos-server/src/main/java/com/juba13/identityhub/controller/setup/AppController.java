package com.juba13.identityhub.controller.setup;
import com.juba13.identityhub.model.App;
import com.juba13.identityhub.model.User;
import com.juba13.identityhub.service.AppService;
import com.juba13.identityhub.service.AuthService;
import com.juba13.identityhub.service.CategoryService;
import com.juba13.identityhub.service.UserService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value = "setup/app")
public class AppController {

    @Autowired
    private AppService service;
   
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("apps", this.service.list());
        return "app-list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        App app = new App();
        app.setNewApp(true);
        app.setId(UUID.randomUUID());
        app.setPublicKey(service.getKey(UUID.randomUUID().toString()));
        app.setPrivateKey(service.getKey(UUID.randomUUID().toString()));
        model.addAttribute("app", app);
        model.addAttribute("categories", categoryService.list());
        return "app-view";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") UUID id, Model model) {
        App app=service.get(id);
        app.setNewApp(false);
        model.addAttribute("app", app);
        model.addAttribute("categories", categoryService.list());
        return "app-view";
    }
    
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String users(@PathVariable("id") UUID id, Model model) {
        App app=service.get(id);
        List<User> users= userService.listActive();
        model.addAttribute("app", app);
        model.addAttribute("users", users);
        return "app-users";
    }
    
    
    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String usersSave(
            @RequestParam(name = "app_id") UUID appId, 
            @RequestParam(name = "user_id[]" ,required = false) UUID[] userIds,  Model model) {
            App app=service.get(appId);
            app.getUsers().clear();
            if(app!=null && userIds!=null){
                for (UUID userId : userIds) {
                    app.getUsers().add(userService.get(userId));
                }
            } 
            service.update(app);
            return "redirect:/setup/app/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("app") App app, Model model) {
        try {
            if(app.getNewApp()) {
              this.service.add(app);
            } else {
              this.service.update(app);
            }
            return "redirect:/setup/app/edit/" + app.getId().toString();
        } catch (Exception e) {
            model.addAttribute("app", app);
            model.addAttribute("categories", categoryService.list());
            model.addAttribute("error_message", e.getMessage());
            return "app-view";
        }
    }

    @RequestMapping(value = "/change-state/{id}/{active}", method = RequestMethod.GET)
    public String changeState(@PathVariable("id") UUID id, @PathVariable("active") boolean active, Model model) {
        this.service.changeState(id, active);
        return "redirect:/setup/app/list";
    }
    
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("USER", authService.getUser());
    }
}
