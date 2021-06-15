package com.android.restapi.demo.car;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Primary
@Repository
public class JdbcCarRepository implements CarRepository{
    private static final String SELECT_ALL = "SELECT id, make, model, dateYear, image FROM car";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public JdbcCarRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("car")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Car> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToCar));
    }

    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        return new Car(
                rs.getLong("id"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getString("dateYear"),
                rs.getString("image")
        );
    }

}
