package com.example.oauth.service.impl;

import com.example.oauth.exception.NotFoundException;
import com.example.oauth.model.Authorization;
import com.example.oauth.repository.AuthorizationRepository;
import com.example.oauth.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessRequestServiceImpl implements AccessRequestService {

    @Autowired
    AuthorizationRepository repository;

    @Override
    public Authorization getAccessRequest(String code) {
        Optional<Authorization> accessRequestResponse = repository.findByCode(code);

        if (accessRequestResponse.isPresent()) {

            return accessRequestResponse.get();
        } else {
            throw new NotFoundException("Access request not found.");
        }
    }

}
