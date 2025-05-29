package com.example.polishCommunity.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "health_survey_responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HealthSurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String location;

    @Column(nullable = false)
    private String gpRegistered;

    @Column(nullable = false)
    private String q2queries;

    public HealthSurveyResponse(String name, String email, String location, String gpRegistered, String q2queries) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.gpRegistered = gpRegistered;
        this.q2queries = q2queries;
    }
}
