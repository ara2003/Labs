package com.example.pzs.controller.advice.exception;

public class VideoAlreadyVerified extends RuntimeException {

    public VideoAlreadyVerified(Long userId, Long videoId) {
        super("user = " + userId + " video = " + videoId);
    }

}
