package com.example.oauth.repository;

import com.example.oauth.model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    Optional<Authorization> findByCode(String code);

}
