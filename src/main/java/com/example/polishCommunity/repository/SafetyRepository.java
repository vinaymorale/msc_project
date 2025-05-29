package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Safety;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SafetyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SafetyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Safety> rowMapper = (ResultSet rs, int rowNum) -> {
        Safety safety = new Safety();
        safety.setId(rs.getInt("id"));
        safety.setName(rs.getString("name"));
        safety.setDescription(rs.getString("description"));
        safety.setLocation(rs.getString("location"));
        safety.setLink(rs.getString("link"));
        safety.setPhone(rs.getString("phone"));
        return safety;
    };

    public List<Safety> getAllSafetyItems() {
        String sql = "SELECT * FROM safety";
        return jdbcTemplate.query(sql, rowMapper);
    }
}