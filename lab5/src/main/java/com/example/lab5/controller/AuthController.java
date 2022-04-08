package com.example.lab5.controller;

import com.example.lab5.model.LoginRequest;
import com.example.lab5.model.LoginResponse;
import com.example.lab5.model.RefreshTokenRequest;
import com.example.lab5.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService  authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
