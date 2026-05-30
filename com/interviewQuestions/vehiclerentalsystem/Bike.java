package com.interviewQuestions.vehiclerentalsystem;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(
            String id,
            String number) {

        super(
                id,
                number,
                VehicleType.BIKE);
    }
}