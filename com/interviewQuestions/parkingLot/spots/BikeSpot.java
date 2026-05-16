package com.interviewQuestions.parkingLot.spots;

import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.utility.VehicleType;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(String id, int distance) {
        super(id, distance);
    }

    public boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.BIKE;
    }
    
}
