package com.example.oauth.service.impl;

import com.example.oauth.dto.AuthorizeRequest;
import com.example.oauth.exception.InvalidRequestException;
import com.example.oauth.exception.NotFoundException;
import com.example.oauth.model.Authorization;
import com.example.oauth.model.Client;
import com.example.oauth.repository.AuthorizationRepository;
import com.example.oauth.service.AuthorizeService;
import com.example.oauth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    @Autowired
    ClientService clientService;
    @Autowired
    AuthorizationRepository authorizationRepository;

    @Override
    public RedirectView authorize(AuthorizeRequest request) {
        Client client = clientService.getClient(request.getClientId());

        if (client.getGrantType().equals(request.getResponseType()) && client.getRedirectionURIs().contains(request.getRedirectUri()) && client.getScopes().contains(request.getScope())) {

            String code = UUID.randomUUID().toString();
            Authorization authorization = Authorization
                    .builder().code(code).redirectUri(request.getRedirectUri()).clientId(request.getClientId()).state(request.getState()).isValid(false).build();

            authorization = authorizationRepository.save(authorization);

            return new RedirectView("http://localhost:8082/auth/login/" + authorization.getId());
        } else {
            throw new InvalidRequestException("Invalid request.");
        }
    }

    @Override
    public RedirectView continueAuthorize(Long id) {
        Optional<Authorization> authorizationResponse = authorizationRepository.findById(id);

        if (authorizationResponse.isPresent()) {
            Authorization authorization = authorizationResponse.get();
            authorization.setIsValid(true);

            authorizationRepository.save(authorization);

            return new RedirectView(authorization.getRedirectUri() + "?code=" + authorization.getCode() + "&state=" + authorization.getState());
        } else {
            throw new NotFoundException("Authorization request not found.");
        }
    }

}
