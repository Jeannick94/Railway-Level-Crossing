package com.example.sensorapp.controllerstate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class Gate {
    private TrainPosition trainPosition;
    private Boolean clock;

    public Gate() {
    }

    public Gate(Boolean clock) {
        this.clock = clock;
    }


    public Gate(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
    }

    public Gate(TrainPosition trainPosition, Boolean clock) {
        this.trainPosition = trainPosition;
        this.clock = clock;
    }

    public TrainPosition getTrainPosition() {
        return trainPosition;
    }

    public void setTrainPosition(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
    }

    public Boolean getClock() {
        return clock;
    }

    public void setClock(Boolean clock) {
        this.clock = clock;
    }

    public Boolean closeOpenGate(Boolean clock) {
        return !clock;
    }


}
