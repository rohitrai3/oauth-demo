package com.example.oauth.service.impl;

import com.example.oauth.repository.ClientRepository;
import com.example.oauth.service.ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return clientRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Client does not exist."));
    }

}
