package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AddEventRepository {

    private final JdbcTemplate jdbcTemplate;

    public AddEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for converting ResultSet to Event object (if you plan to retrieve data in this repo)
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

    // Insert event into the database
    public void addEvent(Event event) {
        String sql = "INSERT INTO eventss (title, date, location, category, description, image_url) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                event.getTitle(),
                event.getDate(),
                event.getLocation(),
                event.getCategory(),
                event.getDescription(),
                event.getImageUrl() != null ? event.getImageUrl() : "default-image-url.jpg");
    }
}
