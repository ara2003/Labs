package com.example.pzs.controller;

import com.example.pzs.controller.advice.exception.ForbiddenException;
import com.example.pzs.entity.User;
import org.springframework.security.core.Authentication;

public class Util {

    public static User authenticated(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated())
            return (User) authentication.getPrincipal();
        throw new ForbiddenException();
    }

}
