package com.interviewQuestions.parkingLot.spots;

import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.utility.VehicleType;

public class TruckSpot extends ParkingSpot {
    public TruckSpot(String id, int distance) {
        super(id, distance);
    }

    public boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.TRUCK;
    }
    
}
