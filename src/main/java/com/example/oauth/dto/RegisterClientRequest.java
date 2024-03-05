package com.example.oauth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientRequest {

    private List<String> redirectionURIs;
    private String applicationName;
    private String website;
    private String description;
    private boolean acceptanceOfLegalTerms;
    private String grantType;
    private List<String> scopes;

}
