package com.example.skillsPage.repository;

import com.example.skillsPage.model.Skills;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SkillsRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Skills> skillsRowMapper = new RowMapper<>() {
        @Override
        public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
            int duration = rs.getInt("duration");
            String formattedDuration = formatDuration(duration);

            return new Skills(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("link"),
                    formattedDuration,
                    rs.getDate("expiryDate").toLocalDate()
            );
        }
    };

    public SkillsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Skills> findAll() {
        String sql = "SELECT name, description, link, duration, expiryDate FROM Skills";
        return jdbcTemplate.query(sql, skillsRowMapper);
    }

    private String formatDuration(int duration) {
        int days = duration / 24;
        int hours = duration % 24;
        if (days > 0) {
            return String.format("%dd%dh", days, hours);
        } else {
            return String.format("%dh", hours);
        }
    }
}
