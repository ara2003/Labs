package com.example.pzs.service;

import com.example.pzs.dto.TokensDTO;
import com.example.pzs.dto.request.SignUserRequest;

public interface SignUpAuthService {

    TokensDTO signup(SignUserRequest data);

}
