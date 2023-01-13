package com.example.demo.dao.daoImpl;

import com.example.demo.dao.SensorDao;
import com.example.demo.model.Sensor;
import com.example.demo.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class SensorDaoImpl implements SensorDao {

    @Autowired
    private SensorRepository sensorRepository;

    JdbcTemplate jdbcTemplate;

    @Override
    public List<Sensor> findAll() {
        return null;
    }

    @Override
    public void saveSensor(Sensor sensor) {
        this.sensorRepository.save(sensor);
    }

    @Override
    public Sensor findById(int id) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int save(Sensor sensor) {
        return jdbcTemplate.update("INSERT INTO sensor (name, model, type, range, unit, location, description) VALUES (?, ?, ?, ?, ?, ?, ?)",
                new Object[]{sensor.getNames(), sensor.getModels(), sensor.getTypes(), sensor.getRanges(), sensor.getUnits(), sensor.getLocation(), sensor.getDescription()});
    }
}
