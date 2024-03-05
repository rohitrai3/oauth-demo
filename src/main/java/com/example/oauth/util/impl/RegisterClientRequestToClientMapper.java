package com.example.oauth.util.impl;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.model.Client;
import com.example.oauth.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterClientRequestToClientMapper implements Mapper<RegisterClientRequest, Client> {

    @Override
    public Client map(RegisterClientRequest request) {

        return Client.builder().redirectionURIs(request.getRedirectionURIs()).applicationName(request.getApplicationName()).website(request.getWebsite()).description(request.getDescription()).acceptanceOfLegalTerms(request.isAcceptanceOfLegalTerms()).grantType(request.getGrantType()).scopes(request.getScopes()).build();
    }

}
