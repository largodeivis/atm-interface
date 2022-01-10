package com.atm.atminterface.controller;

import com.atm.atminterface.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userid")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @PostMapping("/login")
    public String showWelcomePage(ModelMap model, @RequestParam String userid, @RequestParam String strPin){
        boolean isValidUser =  service.validateUser(userid, strPin);

        if (!isValidUser){
            model.put("ErrorMessage", "Invalid credentials for user: " + userid + ".\n");
            return "login";
        }

        model.put("userid", userid);
        return "welcome";
    }
}
