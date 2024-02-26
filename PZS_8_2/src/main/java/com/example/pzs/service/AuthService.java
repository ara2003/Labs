package com.example.pzs.service;

import com.example.pzs.dto.TokensDTO;
import com.example.pzs.dto.request.SignUserRequest;

public interface AuthService {

    String refreshToken(String refreshToken);

    TokensDTO signin(SignUserRequest request);

    boolean isRefreshToken(String refreshToken);

    boolean isAccessToken(String accessToken);

}
