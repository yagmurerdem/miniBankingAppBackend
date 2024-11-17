package com.mybankingapp.miniBankingApp.dto;

import com.mybankingapp.miniBankingApp.model.Transaction;
import com.mybankingapp.miniBankingApp.enums.TransactionStatus;


import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;




public class TransactionResponse {
    private UUID id;
    private String fromAccountId;
    private String toAccountId;
    private BigDecimal amount;
    private TransactionStatus status;
    private LocalDateTime transactionDate;

    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.fromAccountId = transaction.getFrom().getId().toString();
        this.toAccountId = transaction.getTo().getId().toString();
        this.amount = transaction.getAmount();
        this.status = transaction.getStatus();
        this.transactionDate = transaction.getTransactionDate();
    }

    public UUID getId() {
        return id;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
