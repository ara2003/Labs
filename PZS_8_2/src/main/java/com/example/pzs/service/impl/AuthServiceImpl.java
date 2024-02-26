package com.example.pzs.service.impl;

import com.example.pzs.controller.advice.exception.NotValidJWT;
import com.example.pzs.dto.TokensDTO;
import com.example.pzs.dto.request.SignUserRequest;
import com.example.pzs.entity.User;
import com.example.pzs.security.JwtProvider;
import com.example.pzs.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider provider;

    public String refreshToken(String refreshToken) {
        if (!provider.isValidateRefreshToken(refreshToken))
            throw new NotValidJWT();
        var id = provider.getRefreshId(refreshToken);
        var access_token = provider.generateAccessToken(id);
        return access_token;
    }

    @Override
    public TokensDTO signin(SignUserRequest request) {
        try {
            var username = request.getUsername();
            var password = request.getPassword();
            var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = (User) authentication.getPrincipal();
            var access_token = provider.generateAccessToken(user);
            var refresh_token = provider.generateRefreshToken(user);
            return TokensDTO.builder()
                    .accessToken(access_token)
                    .refreshToken(refresh_token)
                    .build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied", e);
        }
    }

    @Override
    public boolean isRefreshToken(String refreshToken) {
        return provider.isValidateRefreshToken(refreshToken);
    }

    @Override
    public boolean isAccessToken(String accessToken) {
        return provider.isValidateAccessToken(accessToken);
    }

}