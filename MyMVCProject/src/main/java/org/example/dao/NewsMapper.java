package org.example.dao;

import org.example.model.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news = new News(
                rs.getString("name"),
                rs.getString("tittle"),
                rs.getString("type")
        );

        return news;
    }
}
