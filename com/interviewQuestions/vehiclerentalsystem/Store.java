package com.interviewQuestions.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

public class Store {
    String storeId;
    Location location;
    public VehicleInventoryManager inventoryManager;
    List<Reservation> reservations;

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.inventoryManager = new VehicleInventoryManager();
        this.reservations = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public VehicleInventoryManager getInventoryManager() {
        return inventoryManager;
    }
}