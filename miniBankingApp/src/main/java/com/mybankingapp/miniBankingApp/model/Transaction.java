package com.mybankingapp.miniBankingApp.model;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.mybankingapp.miniBankingApp.enums.TransactionStatus;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "from_account_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_from_account"))
    private Account from;

    @ManyToOne
    @JoinColumn(name = "to_account_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_to_account"))
    private Account to;

    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Transaction() {
    }

    public Transaction(UUID id, Account from, Account to, BigDecimal amount, LocalDateTime transactionDate, TransactionStatus status) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.status = status;
    }
}
