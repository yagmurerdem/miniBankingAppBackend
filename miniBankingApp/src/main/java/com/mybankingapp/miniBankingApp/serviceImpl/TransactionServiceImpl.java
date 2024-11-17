package com.mybankingapp.miniBankingApp.service.impl;

import com.mybankingapp.miniBankingApp.dto.TransactionRequest;
import com.mybankingapp.miniBankingApp.dto.TransactionResponse;
import com.mybankingapp.miniBankingApp.exception.InsufficientBalanceException;
import com.mybankingapp.miniBankingApp.exception.ResourceNotFoundException;
import com.mybankingapp.miniBankingApp.model.Account;
import com.mybankingapp.miniBankingApp.model.Transaction;

import com.mybankingapp.miniBankingApp.repository.AccountRepository;
import com.mybankingapp.miniBankingApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;*/
import com.mybankingapp.miniBankingApp.service.TransactionService;
import com.mybankingapp.miniBankingApp.enums.TransactionStatus;

@Component
@Service
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public TransactionResponse initiateTransfer(TransactionRequest transactionRequest, String username) {
        Account fromAccount = accountRepository.findById(UUID.fromString(transactionRequest.getFromAccountId()))
                .filter(account -> account.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ResourceNotFoundException("From account not found or unauthorized"));

        Account toAccount = accountRepository.findById(UUID.fromString(transactionRequest.getToAccountId()))
                .orElseThrow(() -> new ResourceNotFoundException("To account not found"));

        if (fromAccount.getBalance().compareTo(transactionRequest.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for this transaction");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(transactionRequest.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(transactionRequest.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setFrom(fromAccount);
        transaction.setTo(toAccount);
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        Transaction savedTransaction = transactionRepository.save(transaction);

        return new TransactionResponse(savedTransaction);
    }

    @Override
    public List<TransactionResponse> getTransactionHistory(String accountId, String username) {
        Account account = accountRepository.findById(UUID.fromString(accountId))
                .filter(acc -> acc.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found or unauthorized"));

        return transactionRepository.findByAccountId(account.getId())
                .stream()
                .map(TransactionResponse::new)
                .collect(Collectors.toList());
    }
}
