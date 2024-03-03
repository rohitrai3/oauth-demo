package com.example.oauth.service;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.dto.RegisterClientResponse;

public interface IClientService {

    RegisterClientResponse registerClient(RegisterClientRequest request);

}
