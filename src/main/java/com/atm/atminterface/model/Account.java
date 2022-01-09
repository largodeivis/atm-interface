package com.atm.atminterface.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Account {
    private int id;

    @NotBlank(message="User ID must not be blank.")
    private String customer; //Change to Customer class

    @NotBlank(message="Customer Name must not be blank.")
    private String name;

    @Size(min=4, message="PIN must be 4 or more digits.")
    @PositiveOrZero(message="PIN must be numerical.")
    private String pin;

    @PositiveOrZero(message="Balance should be greater than or equal to 0.")
    private BigDecimal balance;

    public Account(){
        super();
    };

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
