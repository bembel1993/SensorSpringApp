package com.example.demo.mapper;

import com.example.demo.model.Sensor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorRowMapper implements RowMapper<Sensor> {

    @Override
    public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub

        Sensor sensor = new Sensor();
        sensor.setId(rs.getInt("id"));
        sensor.setNames(rs.getString("name"));
        sensor.setModels(rs.getString("model"));
        sensor.setTypes(rs.getString("typess"));
        sensor.setRanges(rs.getString("rangess"));
        sensor.setUnits(rs.getString("unitss"));
        sensor.setLocation(rs.getString("location"));
        sensor.setDescription(rs.getString("description"));
        return sensor;
    }
}
