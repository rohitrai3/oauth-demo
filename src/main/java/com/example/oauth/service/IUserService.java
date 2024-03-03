package com.example.oauth.service;

import com.example.oauth.dto.SignupRequest;
import com.example.oauth.dto.SignupResponse;

public interface IUserService {

    SignupResponse signup(SignupRequest request);

}
