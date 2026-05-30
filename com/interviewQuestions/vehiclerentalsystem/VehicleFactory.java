package com.interviewQuestions.vehiclerentalsystem;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, String id, String number) {
        switch (type) {
            case CAR:
                return new Car(id, number);
            case BIKE:
                return new Bike(id, number);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }
}
