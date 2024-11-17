package com.mybankingapp.miniBankingApp.controller;

import com.mybankingapp.miniBankingApp.dto.AccountRequest;
import com.mybankingapp.miniBankingApp.dto.AccountResponse;
import com.mybankingapp.miniBankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RestController
@RequestMapping("/api/accounts")

public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest, Authentication authentication) {
        AccountResponse account = accountService.createAccount(accountRequest, authentication.getName());
        return ResponseEntity.status(201).body(account);
    }

    @PostMapping("/search")
    public ResponseEntity<List<AccountResponse>> searchAccounts(@RequestParam String query, Authentication authentication) {
        List<AccountResponse> accounts = accountService.searchAccounts(query, authentication.getName());
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable UUID id, @RequestBody AccountRequest accountRequest, Authentication authentication) {
        AccountResponse account = accountService.updateAccount(id, accountRequest, authentication.getName());
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id, Authentication authentication) {
        accountService.deleteAccount(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountDetails(@PathVariable UUID id, Authentication authentication) {
        AccountResponse account = accountService.getAccountDetails(id, authentication.getName());
        return ResponseEntity.ok(account);
    }
}
