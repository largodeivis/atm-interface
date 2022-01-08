package com.atm.atminterface.service;

import com.atm.atminterface.model.Account;
//import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class AccountService {
//    public static List<Account> accounts = new ArrayList<>();
//
//    //@Value("${CURRENCY}") --DO THIS LATER CAUSING failure
//    private static String currency = "USD";
//
//    static {
//        accounts.add(new Account(1, "user1", Money.of(100.00, currency)));
//        accounts.add(new Account(1, "user2", Money.of(203.32, currency)));
//        accounts.add(new Account(1, "user3", Money.of(5.22, currency)));
//    }
//
//    public Money retrieveBalance(String user){
//        for(Account account : accounts){
//            if (account.getCustomer().equalsIgnoreCase(user)){
//                return account.getBalance();
//            }
//        }
//
//        return Money.of(0,currency); //shouldn't happen
//    }
}
