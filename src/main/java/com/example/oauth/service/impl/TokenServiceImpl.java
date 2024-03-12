package com.example.oauth.service.impl;

import com.example.oauth.dto.GetTokenRequest;
import com.example.oauth.dto.GetTokenResponse;
import com.example.oauth.dto.VerifyTokenRequest;
import com.example.oauth.dto.VerifyTokenResponse;
import com.example.oauth.exception.InvalidRequestException;
import com.example.oauth.exception.InvalidTokenException;
import com.example.oauth.model.Authorization;
import com.example.oauth.service.AccessRequestService;
import com.example.oauth.service.TokenService;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${app.signing-key}")
    private String secretString;
    @Autowired
    AccessRequestService accessRequestService;

    @Override
    public GetTokenResponse getToken(GetTokenRequest request) {
        Authorization accessRequest = accessRequestService.getAccessRequest(request.getCode());

        if (accessRequest.getRedirectUri().equals(request.getRedirectUri()) && accessRequest.getClientId().equals(request.getClientId())) {
            System.out.println("clientId: " + request.getClientId());
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
            int ONE_HOUR = 3600000;
            int TWO_HOUR = 7200000;
            String tokenType = "jwt";

            String accessToken = Jwts.builder()
                    .subject(request.getClientId())
                    .expiration(new Date(new Date().getTime() + ONE_HOUR))
                    .issuedAt(new Date())
                    .signWith(key)
                    .compact();

            String refreshToken = Jwts.builder()
                    .subject(request.getClientId())
                    .expiration(new Date(new Date().getTime() + TWO_HOUR))
                    .notBefore(new Date(new Date().getTime() + ONE_HOUR))
                    .issuedAt(new Date())
                    .signWith(key)
                    .compact();

            return GetTokenResponse.builder()
                    .accessToken(accessToken)
                    .tokenType(tokenType)
                    .expiresIn(ONE_HOUR)
                    .refreshToken(refreshToken)
                    .build();
        } else {
            throw new InvalidRequestException("Invalid client or redirect URI.");
        }
    }

    @Override
    public VerifyTokenResponse verifyToken(VerifyTokenRequest request) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

        try {
            Jwts.parser().verifyWith(key).requireSubject(request.getClientId()).build().parseSignedClaims(request.getToken());
        } catch (InvalidClaimException e) {
            throw new InvalidTokenException();
        }

        return VerifyTokenResponse.builder().isValid(true).build();
    }

}
