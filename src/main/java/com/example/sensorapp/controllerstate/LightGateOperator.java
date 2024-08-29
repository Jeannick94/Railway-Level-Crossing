package com.example.sensorapp.controllerstate;

import com.example.sensorapp.sensor.Sensor;

public class LightGateOperator {
    private Sensor sensor;
    private TrainPosition trainPosition;

    public LightGateOperator(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
    }

    public LightGateOperator(Sensor sensor) {
        this.sensor = sensor;
    }

    public LightGateOperator(Sensor sensor, TrainPosition trainPosition) {
        this.sensor = sensor;
        this.trainPosition = trainPosition;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public TrainPosition getTrainPosition() {
        return trainPosition;
    }

    public void setTrainPosition(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
