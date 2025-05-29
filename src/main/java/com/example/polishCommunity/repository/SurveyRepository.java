package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.SurveyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(SurveyResponse surveyResponse) {
        String sql = "INSERT INTO survey_responses (name, email, question1, question2, question3, question4, question5, question6, question7, question8, question9, question10) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                surveyResponse.getName(),
                surveyResponse.getEmail(),
                surveyResponse.getQuestion1(),
                surveyResponse.getQuestion2(),
                surveyResponse.getQuestion3(),
                surveyResponse.getQuestion4(),
                surveyResponse.getQuestion5(),
                surveyResponse.getQuestion6(),
                surveyResponse.getQuestion7(),
                surveyResponse.getQuestion8(),
                surveyResponse.getQuestion9(),
                surveyResponse.getQuestion10());
    }
}
