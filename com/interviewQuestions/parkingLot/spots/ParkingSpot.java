package com.interviewQuestions.parkingLot.spots;

import com.interviewQuestions.parkingLot.entities.Vehicle;

public abstract class ParkingSpot {
    public String id;
    public boolean occupied;
    public Vehicle vehicle;
    public int distanceFromGate;

    public ParkingSpot(String id, int distanceFromGate) {
        this.id = id;
        this.distanceFromGate = distanceFromGate;
    }

    public abstract boolean canFit(Vehicle vehicle);

    public boolean isAvailable() {
        return !occupied;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void release() {
        vehicle = null;
        occupied = false;
    }
}
