package com.atm.atminterface.controller;

import com.atm.atminterface.exception.InsufficientBalanceException;
import com.atm.atminterface.model.Account;
import com.atm.atminterface.service.AccountService;
import com.atm.atminterface.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("account", new Account(0, "", "", "", new BigDecimal("0.00")));
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(ModelMap model, @Valid Account account, BindingResult result){
        if (result.hasErrors()){
            return "create-account";
        }

        service.createAccount(account.getCustomer(), account.getName(), account.getPin(), account.getBalance());
        model.put("userid", account.getCustomer());

        return "redirect:/account";
    }

    @GetMapping("/list-accounts")
    public String getAccountList(ModelMap model){
        model.put("accounts", service.getAccounts());
        return "account-list";
    }

    @GetMapping("/get-account")
    public String getAccount(ModelMap model, @RequestParam String userid){
        Account account = service.getAccount(userid);
        model.put("userid", userid);
        model.put("balance", account.getBalance());
        return "account";
    }

//    @GetMapping("/deposit")
//    public String showDepositPage(ModelMap model, @RequestParam String userid){
//        Account account = service.getAccount(userid);
//        model.put("account", account);
//        return "deposit";
//    }

//    @PostMapping("/deposit")
//    public String depositMoneyIntoAccount(ModelMap model, @Valid Account account, BindingResult result){
//        if (result.hasErrors()){
//            return "deposit";
//        }
//        service.depositMoney(account.getCustomer(), account.getBalance());
//        return "redirect:/account";
//    }
    @GetMapping("/deposit")
    public String depositMoneyIntoAccount(ModelMap model, @RequestParam String customer, @RequestParam String amount){
        if(!AccountUtil.validateBalance(amount)){
            model.put("ErrorMessage", "Amount must be a positive number.");
            model.put("balance", service.retrieveBalance(customer));
            return "account";
        }

        model.put("userid", customer);
        model.put("balance", service.depositMoney(customer, amount));
        return "account";
    }

    @GetMapping("/withdraw")
    public String withdrawMoneyFromAccount(ModelMap model, @RequestParam String customer, @RequestParam String amount) {
        try {
            if (!AccountUtil.validateBalance(amount)) {
                model.put("ErrorMessage", "Amount must be a positive number.");
                model.put("balance", service.retrieveBalance(customer));
                return "account";
            }

            model.put("userid", customer);
            model.put("balance", service.withdrawMoney(customer, amount));
        } catch (InsufficientBalanceException exception){
            model.put("ErrorMessage", exception.getMessage());
            model.put("balance", service.retrieveBalance(customer));
        }
        return "account";
    }
}
