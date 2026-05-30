package com.interviewQuestions.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleStatus;
import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;

public class VehicleInventoryManager {
    public List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(VehicleType type) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicleType == type && vehicle.getStatus() == VehicleStatus.AVAILABLE) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }
}
