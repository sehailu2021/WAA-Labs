package com.example.lab5.service;

import com.example.lab5.security.request.LoginRequest;
import com.example.lab5.security.response.LoginResponse;
import com.example.lab5.security.request.RefreshTokenRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
