package com.interviewQuestions.parkingLot;

import com.interviewQuestions.parkingLot.entities.ParkingFloor;
import com.interviewQuestions.parkingLot.entities.ParkingLot;
import com.interviewQuestions.parkingLot.entities.Ticket;
import com.interviewQuestions.parkingLot.entities.Vehicle;
import com.interviewQuestions.parkingLot.gates.EntranceGate;
import com.interviewQuestions.parkingLot.gates.ExitGate;

import com.interviewQuestions.parkingLot.parkingStrategy.StrategyFactory;
import com.interviewQuestions.parkingLot.spots.ParkingSpotFactory;
import com.interviewQuestions.parkingLot.utility.FeeStrategy;
import com.interviewQuestions.parkingLot.utility.VehicleType;

public class Main {
    public static void main(String[] args) {

        // Fee strategy
        FeeStrategy feeStrategy = StrategyFactory.getFeeStrategy("HOURLY");

        // Parking lot
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.feeStrategy = feeStrategy;

        // -----------------------------
        // Create Floor 1
        // -----------------------------
        ParkingFloor floor1 = new ParkingFloor("F1");

        floor1.spots.add(ParkingSpotFactory.createSpot(VehicleType.CAR, "C1", 10));
        floor1.spots.add(ParkingSpotFactory.createSpot(VehicleType.CAR, "C2", 20));
        floor1.spots.add(ParkingSpotFactory.createSpot(VehicleType.BIKE, "B1", 5));
        floor1.spots.add(ParkingSpotFactory.createSpot(VehicleType.TRUCK, "T1", 50));

        // -----------------------------
        // Create Floor 2
        // -----------------------------
        ParkingFloor floor2 = new ParkingFloor("F2");

        floor2.spots.add(ParkingSpotFactory.createSpot(VehicleType.CAR, "C3", 15));
        floor2.spots.add(ParkingSpotFactory.createSpot(VehicleType.BIKE, "B2", 8));
        floor2.spots.add(ParkingSpotFactory.createSpot(VehicleType.TRUCK, "T2", 60));

        // Add floors to parking lot
        parkingLot.floors.add(floor1);
        parkingLot.floors.add(floor2);

        // -----------------------------
        // Create Entrance Gates
        // -----------------------------
        EntranceGate entrance1 = new EntranceGate(
                "E1",
                StrategyFactory.getLookupStrategy("NEAREST"));

        EntranceGate entrance2 = new EntranceGate(
                "E2",
                StrategyFactory.getLookupStrategy("FIRST_AVAILABLE"));

        parkingLot.entranceGates.add(entrance1);
        parkingLot.entranceGates.add(entrance2);

        // -----------------------------
        // Create Exit Gates
        // -----------------------------
        ExitGate exit1 = new ExitGate("X1");
        ExitGate exit2 = new ExitGate("X2");

        parkingLot.exitGates.add(exit1);
        parkingLot.exitGates.add(exit2);

        // -----------------------------
        // Create Vehicles
        // -----------------------------
        Vehicle car1 = new Vehicle("WB-01-1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("WB-02-5678", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("WB-03-1111", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("WB-04-9999", VehicleType.TRUCK);

        // -----------------------------
        // Test Parking
        // -----------------------------
        System.out.println("Parking vehicles...");

        Ticket ticket1 = entrance1.parkVehicle(car1);
        System.out.println("Car1 parked at spot: " + ticket1.spot.id);

        Ticket ticket2 = entrance2.parkVehicle(car2);
        System.out.println("Car2 parked at spot: " + ticket2.spot.id);

        Ticket ticket3 = entrance1.parkVehicle(bike1);
        System.out.println("Bike parked at spot: " + ticket3.spot.id);

        Ticket ticket4 = entrance2.parkVehicle(truck1);
        System.out.println("Truck parked at spot: " + ticket4.spot.id);

        // -----------------------------
        // Test Unparking
        // -----------------------------
        System.out.println("\nUnparking vehicles...");

        double fee1 = exit1.unparkVehicle(ticket1);
        System.out.println("Car1 exited. Fee = " + fee1);

        double fee2 = exit2.unparkVehicle(ticket3);
        System.out.println("Bike exited. Fee = " + fee2);

        // -----------------------------
        // Reuse released spot
        // -----------------------------
        Vehicle newCar = new Vehicle("WB-05-7777", VehicleType.CAR);

        Ticket ticket5 = entrance1.parkVehicle(newCar);
        System.out.println("\nNew Car parked at reused spot: " + ticket5.spot.id);
    }
}