package com.example.pzs.controller.advice.exception;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String massage) {
        super(massage);
    }

    public ForbiddenException() {
        super("the current user is not owner");
    }

}
