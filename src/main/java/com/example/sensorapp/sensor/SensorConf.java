package com.example.sensorapp.sensor;

import com.example.sensorapp.controllerstate.LightGateOperator;
import com.example.sensorapp.controllerstate.TrainPosition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SensorConf {
    @Bean
    CommandLineRunner commandLineRunner(SensorRepository repository){
        return args -> {

            Sensor sensor_L = new Sensor(false,"Left");
            Sensor sensor_M = new Sensor(false,"Middle");
            Sensor sensor_R = new Sensor(false,"Right");


            repository.saveAll(List.of(sensor_L,sensor_M,sensor_R));



        };

    }

}
