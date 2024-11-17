package com.mybankingapp.miniBankingApp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



public class TransactionRequest {
    private String fromAccountId;
    private String toAccountId;
    private BigDecimal amount;

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
