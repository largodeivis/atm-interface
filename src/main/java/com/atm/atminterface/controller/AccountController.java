package com.atm.atminterface.controller;

import com.atm.atminterface.model.Account;
import com.atm.atminterface.service.AccountService;
import com.atm.atminterface.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;

@Controller
@SessionAttributes("userid")
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/account")
    public String showAccountPage(ModelMap model){
        String userid = (String) model.get("userid");
        BigDecimal balance = service.retrieveBalance(userid);
        model.put("balance", balance);
        return "account";
    }

    @GetMapping("/create-account")
    public String showCreateAccountPage(ModelMap model){
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(ModelMap model, @RequestParam String userid, @RequestParam String name,
                                @RequestParam String strPin, @RequestParam String verifyPin, @RequestParam String balance){
        if(!AccountUtil.validatePin(strPin)){
            model.put("ErrorMessage", "Invalid PIN. PIN must be numerical.");
            return "create-account";
        }

        if(!AccountUtil.verifyPin(strPin, verifyPin)){
            model.put("ErrorMessage", "Error: PINs must match.");
            return "create-account";
        }

        if(!AccountUtil.validateBalance(balance)){
            model.put("ErrorMessage", "Invalid Balance. Balance must be a positive number.");
            return "create-account";
        }

        service.createAccount(userid, name, strPin, balance);

        return "redirect:/account";
    }

    @GetMapping("/list-accounts")
    public String getAccountList(ModelMap model){
        model.put("accounts", service.getAccounts());
        return "account-list";
    }
}
