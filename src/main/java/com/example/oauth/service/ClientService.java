package com.example.oauth.service;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.dto.RegisterClientResponse;

public interface ClientService {

    public RegisterClientResponse registerClient(RegisterClientRequest request);

}
