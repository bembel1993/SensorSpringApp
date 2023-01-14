package com.example.demo.dao;

import com.example.demo.model.Sensor;

import java.util.List;

public interface SensorDao {
    public List<Sensor> findAll();

    public Sensor findById(int id);

    public int deleteById(int id);

    void saveSensor(Sensor sensor);

    public List<Sensor> searchByName(String searchName);

    public int save(Sensor sensor);
}
