package com.example.oauth.service;

import com.example.oauth.model.Authorization;

public interface AccessRequestService {

    Authorization getAccessRequest(String code);

}
