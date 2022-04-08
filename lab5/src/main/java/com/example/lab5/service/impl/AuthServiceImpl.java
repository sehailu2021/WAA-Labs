package com.example.lab5.service.impl;

import com.example.lab5.model.LoginRequest;
import com.example.lab5.model.LoginResponse;
import com.example.lab5.model.RefreshTokenRequest;
import com.example.lab5.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}
