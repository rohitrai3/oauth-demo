package com.example.oauth.service;

import com.example.oauth.dto.AuthorizeRequest;
import org.springframework.web.servlet.view.RedirectView;

public interface AuthorizeService {

    RedirectView authorize(AuthorizeRequest request);
    RedirectView continueAuthorize(Long id);

}
