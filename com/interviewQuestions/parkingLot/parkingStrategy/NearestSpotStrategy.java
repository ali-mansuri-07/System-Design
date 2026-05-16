package com.interviewQuestions.parkingLot.parkingStrategy;

import java.util.List;

import com.interviewQuestions.parkingLot.entities.ParkingFloor;
import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.spots.ParkingSpot;

public class NearestSpotStrategy implements ParkingSpotLookupStrategy {

    public ParkingSpot findSpot(
            Vehicle vehicle,
            List<ParkingFloor> floors) {

        ParkingSpot nearest = null;

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getAvailableSpots(vehicle)) {

                if (nearest == null ||
                        spot.distanceFromGate < nearest.distanceFromGate) {
                    nearest = spot;
                }
            }
        }

        return nearest;
    }
}