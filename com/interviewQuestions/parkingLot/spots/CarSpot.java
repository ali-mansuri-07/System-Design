package com.interviewQuestions.parkingLot.spots;

import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.utility.VehicleType;

public class CarSpot extends ParkingSpot {
    public CarSpot(String id, int distance) {
        super(id, distance);
    }

    public boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.CAR;
    }
}