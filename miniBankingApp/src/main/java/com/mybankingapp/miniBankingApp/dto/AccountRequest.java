package com.mybankingapp.miniBankingApp.dto;

import java.math.BigDecimal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



public class AccountRequest {
    private String number;
    private String name;
    private BigDecimal balance;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
