package com.example.sensorapp.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
    @Query
    Optional<Sensor>findSensorById(Long id);

//    @Query("SELECT s FROM sensor s WHERE s.position =?1")
//    Optional<Sensor>findSensorByPosition(String sensorPosition);
}

