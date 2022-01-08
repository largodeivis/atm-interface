package com.atm.atminterface.controller;

import com.atm.atminterface.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/account")
    public String showAccountPage(ModelMap model){
        return "account";
    }

//    @PostMapping("/login")
//    public String showAccountPage(ModelMap model, @RequestParam String userid, @RequestParam String strPin){
//
//        boolean isValidUser =  service.validateUser(userid, strPin);
//
//        if (!isValidUser){
//            model.put("ErrorMessage", "Invalid credentials for user: " + userid + ".\n");
//            return "login";
//        }
//        model.put("userid", userid);
//        return "account";
//    }
}
