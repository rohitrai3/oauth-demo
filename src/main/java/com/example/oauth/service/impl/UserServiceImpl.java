package com.example.oauth.service.impl;

import com.example.oauth.dto.SignupRequest;
import com.example.oauth.dto.SignupResponse;
import com.example.oauth.model.User;
import com.example.oauth.repository.UserRepository;
import com.example.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public SignupResponse signup(SignupRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder().username(request.getUsername()).password(encodedPassword).build();
        user.getRoles().add("USER");

        User savedUser = userRepository.save(user);

        return SignupResponse.builder().username(savedUser.getUsername()).build();
    }

}
