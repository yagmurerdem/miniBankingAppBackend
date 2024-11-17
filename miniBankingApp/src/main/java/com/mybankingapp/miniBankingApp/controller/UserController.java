package com.mybankingapp.miniBankingApp.controller;

import com.mybankingapp.miniBankingApp.dto.UserLoginRequest;
import com.mybankingapp.miniBankingApp.dto.UserLoginResponse;
import com.mybankingapp.miniBankingApp.dto.UserRegisterRequest;
import com.mybankingapp.miniBankingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Yeni kullanıcı kaydı
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        userService.registerUser(userRegisterRequest);
        return ResponseEntity.status(201).body("User successfully registered.");
    }

    // Kullanıcı giriş işlemi
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse response = userService.loginUser(userLoginRequest);
        return ResponseEntity.ok(response);
    }
}
