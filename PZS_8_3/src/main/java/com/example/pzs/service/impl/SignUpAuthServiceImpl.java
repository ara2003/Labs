package com.example.pzs.service.impl;

import com.example.pzs.controller.advice.exception.UserAlreadyExists;
import com.example.pzs.dto.TokensDTO;
import com.example.pzs.dto.request.SignUserRequest;
import com.example.pzs.entity.User;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.security.JwtProvider;
import com.example.pzs.service.SignUpAuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpAuthServiceImpl implements SignUpAuthService {

    private final JwtProvider provider;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public TokensDTO signup(SignUserRequest data) {
        var username = data.getUsername();
        var password = data.getPassword();
        {
            var user = userRepository.findByUsername(username);
            if (user.isPresent())
                throw new UserAlreadyExists(user.get().getId(), username);
        }
        var user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user = userRepository.save(user);
        var access_token = provider.generateAccessToken(user);
        var refresh_token = provider.generateRefreshToken(user);
        return TokensDTO.builder()
                .accessToken(access_token)
                .refreshToken(refresh_token)
                .build();
    }

}