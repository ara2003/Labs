package com.example.pzs.controller;

import com.example.pzs.controller.advice.exception.NotHaveRefreshTokenException;
import com.example.pzs.dto.BooleanDTO;
import com.example.pzs.dto.StringDTO;
import com.example.pzs.dto.TokensDTO;
import com.example.pzs.dto.request.SignUserRequest;
import com.example.pzs.dto.response.JwtResponse;
import com.example.pzs.service.AuthService;
import com.example.pzs.service.SignUpAuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private static final String REFRESH_TOKEN = "refresh_token";
    private final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthService service;

    private final SignUpAuthService signUpAuthService;

    @PostMapping("/signup")
    public JwtResponse signup(@RequestBody SignUserRequest request, HttpServletResponse response) {
        LOG.info("signup " + request);
        var tokens = signUpAuthService.signup(request);
        return AuthenticationController.getJwtResponse(response, tokens);
    }

    public static JwtResponse getJwtResponse(HttpServletResponse response, TokensDTO tokens) {
        var access_token = tokens.getAccessToken();
        var refresh_token = tokens.getRefreshToken();
        var cookie = new Cookie(REFRESH_TOKEN, refresh_token);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/auth");
        response.addCookie(cookie);
        return new JwtResponse(access_token);
    }

    @PostMapping("/refreshToken")
    public JwtResponse refreshToken(HttpServletRequest request) {
        LOG.info("refreshToken");
        var refresh_token = getRefreshToken(request);
        if (refresh_token == null)
            throw new NotHaveRefreshTokenException();
        var access_token = service.refreshToken(refresh_token);
        return new JwtResponse(access_token);
    }

    private String getRefreshToken(HttpServletRequest request) {
        var cookies = request.getCookies();
        if (cookies == null)
            return null;
        return Arrays.stream(cookies).filter(x -> x.getName().equals(REFRESH_TOKEN)).findAny()
                .orElse(null).getValue();
    }

    @PostMapping("/signin")
    public JwtResponse signin(@RequestBody SignUserRequest request, HttpServletResponse response) {
        LOG.info("signin " + request);
        var tokens = service.signin(request);
        return getJwtResponse(response, tokens);
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse response) {
        LOG.info("logout");
        var cookie = new Cookie(REFRESH_TOKEN, "");
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/auth");
        response.addCookie(cookie);
    }

    @GetMapping("/isAuthorized")
    public BooleanDTO isAuthorized(HttpServletRequest request, StringDTO accessToken) {
        return new BooleanDTO(isAuthorizedRaw(request, accessToken.value));
    }

    private boolean isAuthorizedRaw(HttpServletRequest request, String accessToken) {
        if (service.isAccessToken(accessToken))
            return true;
        var refreshToken = getRefreshToken(request);
        if (refreshToken == null)
            return false;
        return service.isRefreshToken(refreshToken);
    }

}