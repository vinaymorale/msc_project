package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Safety;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class AddSafetyInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AddSafetyInfoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;}

    //Add the new info into the database
    public void addSafetyInfo(Safety safety){
        String sql = "INSERT INTO safety (name, description, location, link, phone) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                safety.getName(),
                safety.getDescription(),
                safety.getLocation(),
                safety.getLink(),
                safety.getPhone());
    }
}
