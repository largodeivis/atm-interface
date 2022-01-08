package com.atm.atminterface.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Account {
    private int id;
    private String customer; //Change to Customer class
    private String name;
    private String pin;
    private BigDecimal balance;

    public Account(int id, String customer, String name, String pin, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.name = name;
        this.pin = pin;
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
