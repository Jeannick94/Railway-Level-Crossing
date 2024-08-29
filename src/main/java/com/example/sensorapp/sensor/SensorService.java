package com.example.sensorapp.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SensorService {

    //this class is the interface between the controller and the repository (db)
    private final SensorRepository sensorRepository;


    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getSensors(){
        return sensorRepository.findAll();
    }


    @Transactional
    public void updateSensor(Long sensorId, Boolean value, String sensorPosition) {

        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(() -> new IllegalStateException("Sensor id " + sensorId + " doesn't exist"));

        if(value != null  && !Objects.equals(sensor.getValue(),value)){
            sensor.setValue(value);
        }

        if (sensorPosition != null && !sensorPosition.isEmpty() && !Objects.equals(sensor.getPosition(),sensorPosition)){
            sensor.setPosition(sensorPosition);
        }

    }
}
