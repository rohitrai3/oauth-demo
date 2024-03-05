package com.example.oauth.controller;

import com.example.oauth.dto.AuthorizeRequest;
import com.example.oauth.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/authorize")
public class AuthorizeController {

    @Autowired
    AuthorizeService authorizeService;

    @PostMapping
    public RedirectView authorize(AuthorizeRequest request) {

        return authorizeService.authorize(request);
    }

}
