package com.example.resourcesPage.repository;

import com.example.resourcesPage.model.Resources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResourcesRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Resources> resourcesRowMapper = new RowMapper<>() {
        @Override
        public Resources mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Resources(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("access"),
                    rs.getString("link"),
                    rs.getString("address"),
                    rs.getString("phone")
            );
        }
    };

    public ResourcesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Resources> findAll() {
        String sql = "SELECT name, description, access, link, address, phone FROM Resources";
        return jdbcTemplate.query(sql, resourcesRowMapper);
    }
}
