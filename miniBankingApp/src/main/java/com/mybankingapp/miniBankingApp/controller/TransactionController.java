package com.mybankingapp.miniBankingApp.controller;

import com.mybankingapp.miniBankingApp.dto.TransactionRequest;
import com.mybankingapp.miniBankingApp.dto.TransactionResponse;
import com.mybankingapp.miniBankingApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Para transferi başlatma
    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> initiateTransfer(@RequestBody TransactionRequest transactionRequest, Authentication authentication) {
        TransactionResponse transaction = transactionService.initiateTransfer(transactionRequest, authentication.getName());
        return ResponseEntity.status(201).body(transaction);
    }

    // İşlem geçmişini görüntüleme
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionHistory(@PathVariable String accountId, Authentication authentication) {
        List<TransactionResponse> transactions = transactionService.getTransactionHistory(accountId, authentication.getName());
        return ResponseEntity.ok(transactions);
    }
}
