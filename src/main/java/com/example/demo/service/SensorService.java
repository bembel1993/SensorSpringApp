package com.example.demo.service;

import com.example.demo.dao.SensorDao;
import com.example.demo.model.Sensor;
import com.example.demo.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorDao sensorDao;

    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public List<Sensor> searchByName(String searchName) {

        List<Sensor> sensorList = sensorDao.searchByName(searchName);

        return sensorList;
    }
}
