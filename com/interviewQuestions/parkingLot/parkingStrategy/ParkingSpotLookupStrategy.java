package com.interviewQuestions.parkingLot.parkingStrategy;

import java.util.List;

import com.interviewQuestions.parkingLot.entities.ParkingFloor;
import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.spots.ParkingSpot;

public interface ParkingSpotLookupStrategy {
    ParkingSpot findSpot(
            Vehicle vehicle,
            List<ParkingFloor> floors);
}