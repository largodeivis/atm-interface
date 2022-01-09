package com.atm.atminterface.service;

import com.atm.atminterface.exception.InsufficientBalanceException;
import com.atm.atminterface.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    public static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    public static List<Account> accounts = new ArrayList<>();
    public static int accountCount = 3;

    static {
        accounts.add(new Account(1, "user1", "Jay Z","1234", new BigDecimal("100.00")));
        accounts.add(new Account(2, "user2", "Luffy", "9876", new BigDecimal("232.10")));
        accounts.add(new Account(3, "user3", "Daniel LaRusso","7777" ,new BigDecimal("7.15")));
    }

    public void createAccount(String customer, String name, String pin, String balance){
        accounts.add(new Account(++accountCount, customer, name, pin, new BigDecimal(balance)));
    }

    public void createAccount(String customer, String name, String pin, BigDecimal balance){
        accounts.add(new Account(++accountCount, customer, name, pin, balance));
    }

    public BigDecimal retrieveBalance(String userid){
        for(Account account : accounts){
            if (account.getCustomer().equalsIgnoreCase(userid)){
                return account.getBalance();
            }
        }

        return new BigDecimal("0.00"); //Change this to error
    }

    public BigDecimal depositMoney(String userid, BigDecimal amount){
        for(Account account : accounts){
            if (account.getCustomer().equalsIgnoreCase(userid)){
                return account.getBalance().add(amount);
            }
        }
        return new BigDecimal("0.00"); //change this to error
    }

    public BigDecimal depositMoney(String userid, String amount){
        for(Account account : accounts){
            if (account.getCustomer().equalsIgnoreCase(userid)){
                BigDecimal newBalance = account.getBalance().add(new BigDecimal(amount));
                account.setBalance(newBalance);
                return newBalance;
            }
        }
        return new BigDecimal("0.00"); //change this to error
    }

    public BigDecimal withdrawMoney(String user, String amount) throws InsufficientBalanceException {
        for(Account account : accounts){
            if (account.getCustomer().equalsIgnoreCase(user)){
                BigDecimal balance = account.getBalance();
                if (balance.compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal finalMoneyAmount = balance.subtract(new BigDecimal(amount));
                    if (finalMoneyAmount.compareTo(BigDecimal.ZERO) < 0) {
                        throw new InsufficientBalanceException(balance, amount);
                    }
                    account.setBalance(finalMoneyAmount);
                    return finalMoneyAmount;
                } else {
                    throw new InsufficientBalanceException(balance, amount);
                    //custom exception
                }
            }
        }
        return new BigDecimal("0.00"); //change this to error
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String userid){
        for(Account account : accounts){
            if (account.getCustomer().equalsIgnoreCase(userid)){
                return account;
            }
        }
        return null;
    }
}
