package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HousingReply;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HousingReplyRepository {
    private final JdbcTemplate jdbcTemplate;

    public HousingReplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HousingReply> findByQuestionId(Long questionId) {
        String sql = "SELECT * FROM housing_replies WHERE question_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HousingReply.class), questionId);
    }

    public void save(HousingReply reply) {
        String sql = "INSERT INTO housing_replies (name, message, question_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, reply.getName(), reply.getMessage(), reply.getQuestion().getId());
    }
}
