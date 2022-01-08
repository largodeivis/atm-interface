package com.atm.atminterface.controller;

import com.atm.atminterface.service.AccountService;
import com.atm.atminterface.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @PostMapping("/login")
    public String showAccountPage(ModelMap model, @RequestParam String userid, @RequestParam String strPin){

        boolean isValidUser =  service.validateUser(userid, strPin);

        if (!isValidUser){
            model.put("ErrorMessage", "Invalid credentials for user: " + userid + ".\n");
            return "login";
        }
        BigDecimal balance = accountService.retrieveBalance(userid);

        model.put("userid", userid);
        model.put("balance", balance);
        return "account";
    }
}
