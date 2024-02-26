package com.example.pzs.controller.advice.exception;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(Long id) {
        super("Could not find comment with id = " + id);
    }

}
