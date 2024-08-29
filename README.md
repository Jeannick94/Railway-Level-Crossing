

# Railway-Level-Crossing

A simple application for controlling the gate and traffic light based on 3 sensors located before, at, and after the cross-level to avoid collision between cars and trains. This system comprises three components: sensors, controller, and actuators (traffic light and gates). The controller is the brain of the system as it coordinates the movement of the actuators based on the state of the sensors and the previously known location of the train. Hence, this repository mainly focuses on the controller. 


## How to Use

- make sure docker is running and you have a postgres image running (keep the default port mapping)

- docker build -t levelcrossapp_img .
- docker run -d -p 8080:8080 -name=levelcrossapp_cont levelcrossapp_img
- go to http://localhost:8080/api/sensor (you will be able to see the sensor status)
- to change the status of the sensors go to http://localhost:8080/api/sensor/3?value=true and change index and set the value to true or false.
- for the left, middle, and right sensors the index is 1,2,3 respectively.
- to see the train position and progression to http://localhost:8080/api/controller/train

## Notice
- we are still adding features.
- If you encounter a problem, please reach out to us at jeannickumba94@gmail.com


