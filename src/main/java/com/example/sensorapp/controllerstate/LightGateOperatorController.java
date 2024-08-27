package com.example.sensorapp.controllerstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/api/controller")
public class LightGateOperatorController {

    @Autowired
    private final LightGateOperatorService lightGateOperatorService;

    public LightGateOperatorController(LightGateOperatorService lightGateOperatorService) {
        this.lightGateOperatorService = lightGateOperatorService;
    }

    @GetMapping
    public List<Boolean> receivedInfo(){
        return lightGateOperatorService.getStateOfSensors();
    }

    @GetMapping(path = "/train")
    public TrainPosition whereIsTheTrain()  {
        return lightGateOperatorService.getTrainPosition();
    }


}
