package com.interviewQuestions.parkingLot.parkingStrategy;

import java.util.List;

import com.interviewQuestions.parkingLot.entities.ParkingFloor;
import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.spots.ParkingSpot;

public class FirstAvailableStrategy implements ParkingSpotLookupStrategy {

    public ParkingSpot findSpot(
            Vehicle vehicle,
            List<ParkingFloor> floors) {

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getAvailableSpots(vehicle)) {
                return spot;
            }
        }

        return null;
    }
}