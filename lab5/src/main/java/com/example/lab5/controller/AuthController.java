package com.example.lab5.controller;

import com.example.lab5.model.LoginRequest;
import com.example.lab5.model.LoginResponse;
import com.example.lab5.model.RefreshTokenRequest;
import com.example.lab5.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    private  AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Auth Controller");
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
