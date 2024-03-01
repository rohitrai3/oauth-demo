package com.example.oauth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "client")
public class Client {

    @Id
    private String clientId;
    @Column
    private String clientSecret;
    @Column
    private String[] redirectionURIs;
    @Column
    private String applicationName;
    @Column
    private String website;
    @Column
    private String description;
    @Column
    private boolean acceptanceOfLegalTerms;

}
