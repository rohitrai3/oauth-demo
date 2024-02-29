package com.example.oauth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientRequest {

    private String[] redirectionURIs;
    private String applicationName;
    private String website;
    private String description;
    private Byte[] logoImage;
    private boolean acceptanceOfLegalTerms;

}
