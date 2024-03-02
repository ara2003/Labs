package com.example.pzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    String hello() {
        return "hello";
    }

    @GetMapping("/signin")
    String signIn() {
        return "signIn";
    }

    @GetMapping("/signup")
    String signUp() {
        return "signUp";
    }

}
