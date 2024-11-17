package com.mybankingapp.miniBankingApp.service.impl;

import com.mybankingapp.miniBankingApp.dto.AccountRequest;
import com.mybankingapp.miniBankingApp.dto.AccountResponse;
import com.mybankingapp.miniBankingApp.exception.ResourceNotFoundException;
import com.mybankingapp.miniBankingApp.model.Account;
import com.mybankingapp.miniBankingApp.model.User;
import com.mybankingapp.miniBankingApp.repository.AccountRepository;
import com.mybankingapp.miniBankingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import java.util.stream.Collectors;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;*/
import jakarta.persistence.*;
import com.mybankingapp.miniBankingApp.service.AccountService;
@Component
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
@Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Account account = new Account();
        account.setNumber(accountRequest.getNumber());
        account.setName(accountRequest.getName());
        account.setBalance(accountRequest.getBalance() != null ? accountRequest.getBalance() : BigDecimal.ZERO);
        account.setUser(user);

        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount);
    }

    @Override
    public List<AccountResponse> searchAccounts(String query, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return accountRepository.searchAccounts(user.getId(), query)
                .stream()
                .map(AccountResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse updateAccount(UUID id, AccountRequest accountRequest, String username) {
        Account account = accountRepository.findById(id)
                .filter(acc -> acc.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found or unauthorized"));

        account.setName(accountRequest.getName());
        account.setBalance(accountRequest.getBalance());
        accountRepository.save(account);

        return new AccountResponse(account);
    }

    @Override
    public void deleteAccount(UUID id, String username) {
        Account account = accountRepository.findById(id)
                .filter(acc -> acc.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found or unauthorized"));

        accountRepository.delete(account);
    }

    @Override
    public AccountResponse getAccountDetails(UUID id, String username) {
        Account account = accountRepository.findById(id)
                .filter(acc -> acc.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found or unauthorized"));

        return new AccountResponse(account);
    }
}
