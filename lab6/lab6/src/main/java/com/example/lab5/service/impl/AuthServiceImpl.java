package com.example.lab5.service.impl;
import com.example.lab5.security.request.LoginRequest;
import com.example.lab5.security.response.LoginResponse;
import com.example.lab5.security.request.RefreshTokenRequest;
import com.example.lab5.service.AuthService;
import com.example.lab5.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private  final  AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e){

        }
        final String accessToken = jwtUtil.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
             if(isAccessTokenExpired) {
                final String accessToken = jwtUtil.generateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
                return loginResponse;
            }
//            final String accessToken = jwtUtil.generateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
//            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
//            return loginResponse;
        }
        return new LoginResponse();
    }
}
