package com.example.sensorapp.controllerstate;

public class LightGateOperator {
    private DFlipFlop.Sensor sensor;
    private TrainPosition trainPosition;

    public LightGateOperator(TrainPosition trainPosition) {
        this.trainPosition = trainPosition;
    }

    public LightGateOperator(DFlipFlop.Sensor sensor) {
        this.sensor = sensor;
    }

    public LightGateOperator(DFlipFlop.Sensor sensor, TrainPosition trainPosition) {
        this.sensor = sensor;
        this.trainPosition = trainPosition;
    }

    public DFlipFlop.Sensor getSensor() {
        return sensor;
    }

    public void setSensor(DFlipFlop.Sensor sensor) {
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
