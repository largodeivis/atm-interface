package com.atm.atminterface.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Getter
@Setter
public class Account {
    private int id;
    private String customer; //Change to Customer class
    private BigDecimal balance;

    public Account(int id, String customer, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && customer.equals(account.customer) && balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, balance);
    }
}
