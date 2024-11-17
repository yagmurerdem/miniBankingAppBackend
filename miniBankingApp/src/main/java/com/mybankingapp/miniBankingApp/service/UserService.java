package com.mybankingapp.miniBankingApp.service;

import com.mybankingapp.miniBankingApp.dto.UserLoginRequest;
import com.mybankingapp.miniBankingApp.dto.UserLoginResponse;
import com.mybankingapp.miniBankingApp.dto.UserRegisterRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
public interface UserService {
    void registerUser(UserRegisterRequest userRegisterRequest);
    UserLoginResponse loginUser(UserLoginRequest userLoginRequest);
}
