# Railway-Level-Crossing
A simple application for controlling the gate and traffic light based on 3 sensors located before, at, and after the cross-level to avoid collision between cars and trains. This system comprises three components: sensors, controller, and actuarors (trafffic light and gate). The controller is the system's brain as it coordinates the movement of the actuators based on the state of the sensors and the previously known location of the train. Hence, this repository mainly focuses on the controller.
# How to use it
- make sure docker is running and you have a postgres image running (keep the default port mapping)
- docker build -t levelcrossapp_img .
- docker run -d -p 8080:8080 -name=levelcrossapp_cont levelcrossapp_img
