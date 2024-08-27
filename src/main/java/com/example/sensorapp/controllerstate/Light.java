package com.example.sensorapp.controllerstate;

import jakarta.persistence.Entity;


public class Light {
    private TrainPosition trainPosition;
    private Boolean clock;

    public Light() {
    }

    public Light(Boolean clock) {
        this.clock = clock;
    }

    public Light(TrainPosition trainPosition, Boolean clock) {
        this.trainPosition = trainPosition;
        this.clock = clock;
    }

    public Light(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
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

    public Boolean switchOnOffLight(Boolean clock) {
        return !clock;
    }

}
