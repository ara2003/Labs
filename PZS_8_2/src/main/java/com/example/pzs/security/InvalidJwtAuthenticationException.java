package com.example.pzs.security;

public class InvalidJwtAuthenticationException extends RuntimeException {

    public InvalidJwtAuthenticationException(String massage) {
        super(massage);
    }

}
