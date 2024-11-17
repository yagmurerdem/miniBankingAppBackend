package com.mybankingapp.miniBankingApp.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;




public class UserLoginResponse {
    private String username;
    private String token;

    public UserLoginResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
