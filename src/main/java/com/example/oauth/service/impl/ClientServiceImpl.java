package com.example.oauth.service.impl;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.dto.RegisterClientResponse;
import com.example.oauth.model.Client;
import com.example.oauth.repository.ClientRepository;
import com.example.oauth.service.IClientService;
import com.example.oauth.util.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    IMapper<RegisterClientRequest, Client> registerClientRequestToClientMapper;

    @Override
    public RegisterClientResponse registerClient(RegisterClientRequest request) {
        String clientId = UUID.randomUUID().toString();
        String clientSecret = UUID.randomUUID().toString();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedClientSecret = passwordEncoder.encode(clientSecret);

        Client client = registerClientRequestToClientMapper.map(request);
        client.setClientId(clientId);
        client.setClientSecret(encodedClientSecret);

        Client savedClient = clientRepository.save(client);

        return RegisterClientResponse.builder().clientId(savedClient.getClientId()).clientSecret(clientSecret).build();
    }

}
