package com.example.oauth.controller;

import com.example.oauth.dto.AuthorizeRequest;
import com.example.oauth.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/authorize")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorizeController {

    @Autowired
    AuthorizeService authorizeService;

    @PostMapping
    public RedirectView authorize(AuthorizeRequest request) {

        return authorizeService.authorize(request);
    }

    @GetMapping("/continue/{id}")
    public RedirectView continueAuthorize(@PathVariable Long id) {

        return authorizeService.continueAuthorize(id);
    }

}
