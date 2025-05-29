package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.WorkInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcWorkInformationRepository implements WorkInformationRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkInformationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkInformation> findAll() {
        String sql = "SELECT * FROM work_information";
        return jdbcTemplate.query(sql, new WorkInformationRowMapper());
    }

    private static class WorkInformationRowMapper implements RowMapper<WorkInformation> {
        @Override
        public WorkInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
            WorkInformation workInformation = new WorkInformation();
            workInformation.setId(rs.getLong("id"));
            workInformation.setName(rs.getString("name"));
            workInformation.setDescription(rs.getString("description"));
            workInformation.setLink(rs.getString("link"));
            workInformation.setJobType(rs.getString("job_type"));
            workInformation.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
            return workInformation;
        }
    }
}
