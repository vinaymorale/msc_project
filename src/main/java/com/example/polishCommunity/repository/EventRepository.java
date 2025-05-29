package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EventRepository {
    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Event> rowMapper = (ResultSet rs, int rowNum) -> {
        Event event = new Event();
        event.setId(rs.getInt("id"));
        event.setTitle(rs.getString("title"));
        event.setDate(rs.getString("date"));
        event.setLocation(rs.getString("location"));
        event.setCategory(rs.getString("category"));
        event.setDescription(rs.getString("description"));
        event.setImageUrl(rs.getString("image_url"));
        return event;
    };

    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM eventss order by id desc";
        return jdbcTemplate.query(sql, rowMapper);
    }
    public List<Event> getEventsByCategory(String category) {
        String sql = "SELECT * FROM eventss WHERE category = ?";
        return jdbcTemplate.query(sql, rowMapper, category);
    }

    public List<Event> getEventsSortedByDate() {
        String sql = "SELECT * FROM eventss ORDER BY date ASC";
        return jdbcTemplate.query(sql, rowMapper);
    }


}

