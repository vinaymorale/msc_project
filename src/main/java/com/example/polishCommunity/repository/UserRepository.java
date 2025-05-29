package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Register a new user
    public void save(User user) {
        String sql = "INSERT INTO users (name, surname, email, password_hash, role) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getEmail(), user.getPasswordHash(), user.getRole());
    }

    // Find a user by email
    public User findByEmail(String email) {
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email);
        } catch (Exception e) {
            return null; // Return null if the user is not found
        }
    }
}
