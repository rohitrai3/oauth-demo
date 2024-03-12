package com.example.oauth.controller;

import com.example.oauth.dto.GetTokenRequest;
import com.example.oauth.dto.GetTokenResponse;
import com.example.oauth.dto.VerifyTokenRequest;
import com.example.oauth.dto.VerifyTokenResponse;
import com.example.oauth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "http://localhost:3000")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping("/hello")
    public String hello() {

        return "Hello World!";
    }

    @PostMapping
    public GetTokenResponse getToken(GetTokenRequest request) {

        return tokenService.getToken(request);
    }

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public VerifyTokenResponse verifyToken(VerifyTokenRequest request) {

        return tokenService.verifyToken(request);
    }

}
