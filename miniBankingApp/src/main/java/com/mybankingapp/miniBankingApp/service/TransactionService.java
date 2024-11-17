package com.mybankingapp.miniBankingApp.service;

import com.mybankingapp.miniBankingApp.dto.TransactionRequest;
import com.mybankingapp.miniBankingApp.dto.TransactionResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
public interface TransactionService {
    TransactionResponse initiateTransfer(TransactionRequest transactionRequest, String username);
    List<TransactionResponse> getTransactionHistory(String accountId, String username);
}
