package com.example.oauth.service;

import com.example.oauth.dto.GetTokenRequest;
import com.example.oauth.dto.GetTokenResponse;
import com.example.oauth.dto.VerifyTokenRequest;
import com.example.oauth.dto.VerifyTokenResponse;

public interface TokenService {

    GetTokenResponse getToken(GetTokenRequest request);
    VerifyTokenResponse verifyToken(VerifyTokenRequest request);

}
