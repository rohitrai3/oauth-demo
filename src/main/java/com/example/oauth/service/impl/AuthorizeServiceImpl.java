package com.example.oauth.service.impl;

import com.example.oauth.dto.AuthorizeRequest;
import com.example.oauth.exception.InvalidRequestException;
import com.example.oauth.model.Client;
import com.example.oauth.service.AuthorizeService;
import com.example.oauth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    @Autowired
    ClientService clientService;

    @Override
    public RedirectView authorize(AuthorizeRequest request) {
        Client client = clientService.getClient(request.getClientId());

        if (client.getGrantType().equals(request.getResponseType()) && client.getRedirectionURIs().contains(request.getRedirectUri()) && client.getScopes().contains(request.getScope())) {

            return new RedirectView(request.getRedirectUri() + "?code=" + "ThisIsTheAuthorizationCode&state=" + request.getState());
        } else {
            throw new InvalidRequestException("Invalid request.");
        }
    }

}
