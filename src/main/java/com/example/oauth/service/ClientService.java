package com.example.oauth.service;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.dto.RegisterClientResponse;
import com.example.oauth.model.Client;

public interface ClientService {

    RegisterClientResponse registerClient(RegisterClientRequest request);
    Client getClient(String clientId);

}
