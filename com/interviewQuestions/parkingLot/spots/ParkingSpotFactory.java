package com.interviewQuestions.parkingLot.spots;

import com.interviewQuestions.parkingLot.utility.VehicleType;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(VehicleType type, String id, int distanceFromGate) {
        switch (type) {
            case CAR:
                return new CarSpot(id, distanceFromGate);
            case BIKE:
                return new BikeSpot(id, distanceFromGate);
            case TRUCK:
                return new TruckSpot(id, distanceFromGate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
