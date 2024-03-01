package com.example.oauth.controller;

import com.example.oauth.dto.RegisterClientRequest;
import com.example.oauth.dto.RegisterClientResponse;
import com.example.oauth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterClientResponse registerClient(@RequestBody RegisterClientRequest request) {

        return clientService.registerClient(request);
    }

}
