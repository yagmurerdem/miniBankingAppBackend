package com.mybankingapp.miniBankingApp.service;

import com.mybankingapp.miniBankingApp.dto.AccountRequest;
import com.mybankingapp.miniBankingApp.dto.AccountResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
public interface AccountService {
    AccountResponse createAccount(AccountRequest accountRequest, String username);
    List<AccountResponse> searchAccounts(String query, String username);
    AccountResponse updateAccount(UUID id, AccountRequest accountRequest, String username);
    void deleteAccount(UUID id, String username);
    AccountResponse getAccountDetails(UUID id, String username);
}
