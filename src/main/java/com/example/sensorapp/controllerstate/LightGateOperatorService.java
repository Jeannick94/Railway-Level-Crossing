package com.example.sensorapp.controllerstate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LightGateOperatorService {

    @Autowired
    private final SensorRepository sensorRepository;

    public LightGateOperatorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    public List<Boolean> getStateOfSensors(){
        List<DFlipFlop.Sensor> sensors1 = sensorRepository.findAll();
        DFlipFlop.Sensor s1 = sensors1.get(0);
        DFlipFlop.Sensor s2 = sensors1.get(1);
        DFlipFlop.Sensor s3 = sensors1.get(2);

        return List.of(s1.getValue().booleanValue(),s2.getValue().booleanValue(),s3.getValue().booleanValue());
    }

    public Boolean getClkValue() throws InterruptedException {
        DFlipFlop dFlipFlop = new DFlipFlop();
        Boolean clk = dFlipFlop.getClk();
        while (true) {
            //System.out.println("CLK1: " + clk);
            clk = (Boolean) !clk; // Inverse
            //System.out.println("CLK1: " + clk);
            Thread.sleep(1000); // Pause de 1 second
        }
    }

    public String getPreviousTrainPosition(int previousTrainPosition){

        List<String> trainPositions = new ArrayList<>();
        trainPositions.add("AWAY");
        trainPositions.add("APPROACH");
        trainPositions.add("CLOSE");
        trainPositions.add("PRESENT");
        trainPositions.add("LEAVING");
        trainPositions.add("LEFT");
        trainPositions.add("UNEXPECTED_OR_MISSING_TRAIN");


        switch (previousTrainPosition) {
            case 0:
                return trainPositions.get(0);

            case 1:
                //System.out.println("The train is approaching the cross level");
                return trainPositions.get(0);

            case 2:
                return trainPositions.get(1);
                //System.out.println("The train is ver close to the cross level");

            case 3:
                return trainPositions.get(2);
                //System.out.println("The train is crossing the road");

            case 4:
                //System.out.println("The train is leaving the cross level");
                return trainPositions.get(3);

            case 5:
                //System.out.println("The train has left the sensors zone");
                return trainPositions.get(4);

            case 6:
                //System.out.println("The train is either missing or this state is to be developed");
                return "UNEXPECTED_OR_MISSING_TRAIN";

            default:
                System.out.println("Invalid State");
        }
        return trainPositions.get(previousTrainPosition);

    }

    public TrainPosition getTrainPosition()  {
        List<Boolean> sensors = getStateOfSensors();
        Boolean value1 = sensors.get(0);
        Boolean value2 = sensors.get(1);
        Boolean value3 = sensors.get(2);

        DFlipFlop dFlipFlop0 = new DFlipFlop();
        DFlipFlop dFlipFlop1 = new DFlipFlop();
        DFlipFlop dFlipFlop2 = new DFlipFlop();

        Gate gate1 = new Gate();
        Light light1 = new Light();

        Boolean q0 = dFlipFlop0.getQ();
        Boolean q1 = dFlipFlop1.getQ();
        Boolean q2 = dFlipFlop2.getQ();

        List<TrainPosition> trainPositions = new ArrayList<>();


        if((!value1 && !value2 && !value3) && (!q0 && !q1 && !q2)){
            trainPositions.add(TrainPosition.AWAY);
            getPreviousTrainPosition(0);
            return TrainPosition.AWAY;
        }  else if (((!value1 || !value3) && !value2) && (TrainPosition.AWAY.toString().equals(getPreviousTrainPosition(0))))  {
            trainPositions.add(TrainPosition.APPROACH);
            light1.switchOnOffLight(dFlipFlop0.getClk());
            gate1.closeOpenGate(dFlipFlop0.getClk());
            return TrainPosition.APPROACH;
        } else if (((value1 && value3 && !value2) && (TrainPosition.APPROACH.toString().equals(getPreviousTrainPosition(1))))){
            trainPositions.add(TrainPosition.CLOSE);
            return TrainPosition.CLOSE;
        } else if (((value1 && value3) && value2) && (TrainPosition.CLOSE.toString().equals(getPreviousTrainPosition(2)))){
            trainPositions.add(TrainPosition.PRESENT);
            return TrainPosition.PRESENT;
        } else if ((value1 && value3 && !value2) && (TrainPosition.PRESENT.toString().equals(getPreviousTrainPosition(3)))){
            trainPositions.add(TrainPosition.LEAVING);
            light1.switchOnOffLight(Boolean.valueOf(!dFlipFlop0.getClk()));
            gate1.closeOpenGate(Boolean.valueOf(!dFlipFlop0.getClk()));
            return TrainPosition.LEAVING;
        } else if (((!value1 || !value3) && !value2) && (TrainPosition.LEAVING.toString().equals(getPreviousTrainPosition(4)))){
            trainPositions.add(TrainPosition.LEFT);
            return TrainPosition.LEFT;
        }else {
            return TrainPosition.UNEXPECTED_OR_MISSING_TRAIN;
        }


    }

}
