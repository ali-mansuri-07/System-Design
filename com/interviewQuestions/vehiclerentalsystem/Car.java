package com.interviewQuestions.vehiclerentalsystem;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String id, String number) {
        super(id, number, VehicleType.CAR);
    }
    
}
