package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HealthSurveyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class HealthSurveyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(HealthSurveyResponse healthSurveyResponse){
        String sql = "INSERT INTO health_survey_responses (name, email, location, gp_registered, q2queries) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                healthSurveyResponse.getName(),
                healthSurveyResponse.getEmail(),
                healthSurveyResponse.getLocation(),
                healthSurveyResponse.getGpRegistered(),
                healthSurveyResponse.getQ2queries());
    }
}