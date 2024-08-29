
# Sensor-App

A simple application for controlling the gate and traffic light based on 3 sensors located before, at, and after the cross-level to avoid collision between cars and train. This system is made up of three components namely sensors, controller, and actuarors (trafffic light and gate). The controller is the brain of the system as it is in charge of coordinating the movement of the actuarors based on the state of the sensors and the previous known location of the train. Hence, this repository mainly focus on the controller. 


## How to Use

- make sure docker is running and you have a postgres image running (keep the default port mapping)

- docker build -t levelcrossapp_img .
- docker run -d -p 8080:8080 -name=levelcrossapp_cont levelcrossapp_img
- go to http://localhost:8080/api/sensor (you will be able to see the sensor status)
- to change the status of the sensors go to http://localhost:8080/api/sensor/3?value=true and change index and set the value to true or false.
- for the left, middle, and right sensors the index is 1,2,3 respectively.
- to see the train position and progression go to http://localhost:8080/api/controller/train

## Notice
- If you encouter a problem, please reach out to us at jeannickumba94@gmail.com

