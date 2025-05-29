package com.example.organisationsPage.repository;

import com.example.organisationsPage.model.Organisations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrganisationsRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Organisations> organisationsRowMapper = new RowMapper<>() {
        @Override
        public Organisations mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Organisations(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("logo")
            );
        }
    };

    public OrganisationsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Organisations> findAll() {
        String sql = "SELECT name, description, logo FROM Organisations";
        return jdbcTemplate.query(sql, organisationsRowMapper);
    }
}
