package com.example.sensorapp.sensor;

import jakarta.persistence.*;


@Entity
@Table
public class Sensor { //This class is charge of controlling the behavior of the three sensors
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
