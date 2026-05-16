package com.interviewQuestions.parkingLot.gates;

import java.util.UUID;

import com.interviewQuestions.parkingLot.entities.ParkingLot;
import com.interviewQuestions.parkingLot.entities.Ticket;
import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.parkingStrategy.ParkingSpotLookupStrategy;
import com.interviewQuestions.parkingLot.spots.ParkingSpot;

public class EntranceGate {

    public String gateId;
    public ParkingSpotLookupStrategy lookupStrategy;
    public ParkingLot parkingLot;

    public EntranceGate(
            String gateId,
            ParkingSpotLookupStrategy strategy) {
        this.gateId = gateId;
        this.lookupStrategy = strategy;
        this.parkingLot = ParkingLot.getInstance();
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        ParkingSpot spot = lookupStrategy.findSpot(
                vehicle,
                parkingLot.floors);

        if (spot == null) {
            throw new RuntimeException("No spot available");
        }

        spot.park(vehicle);

        return Ticket.builder()
                .id(UUID.randomUUID().toString())
                .vehicle(vehicle)
                .spot(spot)
                .build();
    }
}