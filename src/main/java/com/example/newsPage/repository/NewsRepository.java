package com.example.newsPage.repository;

import com.example.newsPage.model.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<News> newsRowMapper = new RowMapper<>() {
        @Override
        public News mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new News(
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("link"),
                    rs.getDate("date").toLocalDate(),
                    "/images/" + rs.getString("imgUrl")
            );
        }
    };

    public NewsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<News> findAll() {
        String sql = "SELECT title, content, link, date, imgUrl FROM News";
        return jdbcTemplate.query(sql, newsRowMapper);
    }
}
