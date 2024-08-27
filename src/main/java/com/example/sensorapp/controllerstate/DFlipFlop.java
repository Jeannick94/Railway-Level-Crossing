package com.example.sensorapp.controllerstate;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public class DFlipFlop {
    private Boolean d;
    private Boolean q;
    private Boolean clk;

    public DFlipFlop() {
        q = false;
        clk = false;
    }

    public DFlipFlop(Boolean d, Boolean CLK) {
        this.d = d;
        this.clk = CLK;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }

    public Boolean getQ() {
        return q;
    }

    public void setQ(Boolean q) {
        this.q = q;
    }

    public Boolean getClk() {
        return clk;
    }

    public void setClk(Boolean clk) {
        this.clk = clk;
    }

    public void clock() {
        if (clk) {
            q = d;
        }
    }

    @Override
    public String toString() {
        return "DFlipFlop{" +
                "D=" + d +
                ", Q=" + q +
                ", CLK=" + clk +
                '}';
    }

    @Entity
    @Table
    public static class Sensor {
        @Id
        @SequenceGenerator(
                name = "sensor_sequence",
                sequenceName = "sensor_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "sensor_sequence"
        )


        private Long id;
        private Boolean value;
        private String sensorPosition;

        public Sensor() {
        }

        public Sensor(Long id, Boolean value, String sensorPosition) {
            this.id = id;
            this.value = value;
            this.sensorPosition = sensorPosition;
        }

        public Sensor(Boolean value, String sensorPosition) {
            this.value = value;
            this.sensorPosition = sensorPosition;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Boolean getValue() {
            return value;
        }

        public void setValue(Boolean value) {
            this.value = value;
        }

        public String getPosition() {
            return sensorPosition;
        }

        public void setPosition(String position) {
            this.sensorPosition = position;
        }

        @Override
        public String toString() {
            return "Sensor{" +
                    "id=" + id +
                    ", value=" + value +
                    ", sensorPosition='" + sensorPosition + '\'' +
                    '}';
        }
    }

    @RestController
    @RequestMapping(path = "api/sensor")
    public static class SensorController {

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

    @Service
    public static class SensorService {

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
}
