package com.interviewQuestions.parkingLot.entities;

import com.interviewQuestions.parkingLot.spots.ParkingSpot;

import java.util.ArrayList;
import java.util.List;


public class ParkingFloor {
    String floorId;
    public List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSpot> getAvailableSpots(Vehicle vehicle) {
        List<ParkingSpot> result = new ArrayList<>();

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFit(vehicle)) {
                result.add(spot);
            }
        }

        return result;
    }
}