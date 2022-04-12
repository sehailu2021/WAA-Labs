package com.example.lab5.service;


import com.example.lab5.entity.dto.LoginRequest;
import com.example.lab5.entity.dto.LoginResponse;
import com.example.lab5.entity.dto.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
