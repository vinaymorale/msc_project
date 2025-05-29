package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.model.HousingReply;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HousingQuestionnaireRepository {
    private final JdbcTemplate jdbcTemplate;

    public HousingQuestionnaireRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HousingQuestionnaire> findAllWithReplies() {
        String questionSql = "SELECT * FROM housing_questionnaire";
        List<HousingQuestionnaire> questions = jdbcTemplate.query(questionSql, new BeanPropertyRowMapper<>(HousingQuestionnaire.class));

        for (HousingQuestionnaire question : questions) {
            String replySql = "SELECT * FROM housing_replies WHERE question_id = ?";
            List<HousingReply> replies = jdbcTemplate.query(replySql, new BeanPropertyRowMapper<>(HousingReply.class), question.getId());
            question.setReplies(replies); // Set replies for the question
        }

        return questions;
    }

    public void save(HousingQuestionnaire questionnaire) {
        String sql = "INSERT INTO housing_questionnaire (name, email, message) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, questionnaire.getName(), questionnaire.getEmail(), questionnaire.getMessage());
    }
    

}
