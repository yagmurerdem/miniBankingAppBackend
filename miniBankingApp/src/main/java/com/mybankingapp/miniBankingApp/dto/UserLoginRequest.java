package com.mybankingapp.miniBankingApp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



public class UserLoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
