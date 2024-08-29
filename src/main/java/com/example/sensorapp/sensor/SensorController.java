package com.example.sensorapp.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(path = "api/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<Sensor> getSensors(){
        return sensorService.getSensors();
    }


    @PutMapping(path ="{sensorId}")
    public void sendInfo(
            @PathVariable("sensorId") Long sensorId,
            @RequestParam(required = false) Boolean value,
            @RequestParam(required = false) String sensorPosition){
        sensorService.updateSensor(sensorId, value,sensorPosition);
    }
}
