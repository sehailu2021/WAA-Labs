package com.example.lab5.service;

import com.example.lab5.model.LoginRequest;
import com.example.lab5.model.LoginResponse;
import com.example.lab5.model.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
