package com.interviewQuestions.vehiclerentalsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.interviewQuestions.vehiclerentalsystem.enums.ReservationStatus;
import com.interviewQuestions.vehiclerentalsystem.enums.VehicleStatus;
import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;
import com.interviewQuestions.vehiclerentalsystem.strategy.PricingStrategy;

public class VehicleRentalSystem {

    private static VehicleRentalSystem instance;

    private List<User> users;
    private List<Store> stores;

    private VehicleRentalSystem() {
        users = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public static VehicleRentalSystem getInstance() {

        if (instance == null) {
            instance = new VehicleRentalSystem();
        }

        return instance;
    }

    // ---------------------------------
    // User Operations
    // ---------------------------------

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    // ---------------------------------
    // Store Operations
    // ---------------------------------

    public void addStore(Store store) {
        stores.add(store);
    }

    public List<Store> getStores() {
        return stores;
    }

    // ---------------------------------
    // Search Store
    // ---------------------------------

    public Store findStoreByCity(String city) {

        for (Store store : stores) {

            if (store.getLocation()
                    .getCity()
                    .equalsIgnoreCase(city)) {

                return store;
            }
        }

        return null;
    }

    // ---------------------------------
    // Search Vehicle
    // ---------------------------------

    public List<Vehicle> searchVehicles(
            String city,
            VehicleType vehicleType) {

        Store store = findStoreByCity(city);

        if (store == null) {
            return new ArrayList<>();
        }

        return store
                .getInventoryManager()
                .getAvailableVehicles(vehicleType);
    }

    // ---------------------------------
    // Reserve Vehicle
    // ---------------------------------

    public Reservation reserveVehicle(
            User user,
            Vehicle vehicle,
            LocalDate startDate,
            LocalDate endDate) {

        Reservation reservation = new Reservation(
                UUID.randomUUID().toString(),
                user,
                vehicle,
                startDate,
                endDate);

        vehicle.setStatus(
                VehicleStatus.RESERVED);

        reservation.setStatus(
                ReservationStatus.CREATED);

        return reservation;
    }

    // ---------------------------------
    // Generate Bill (auto-select pricing strategy)
    // ---------------------------------

    public Bill generateBill(Reservation reservation) {

        long totalDays = reservation.getToDate()
                .toEpochDay()
                -
                reservation.getFromDate()
                        .toEpochDay();

        PricingStrategy pricingStrategy = getPricingStrategyForVehicle(reservation.getVehicle());

        double amount = pricingStrategy.calculatePrice(
                reservation.getVehicle(),
                (int) totalDays);

        return new Bill(reservation, amount);
    }

    private PricingStrategy getPricingStrategyForVehicle(Vehicle vehicle) {
        switch (vehicle.vehicleType) {
            case CAR:
                return new com.interviewQuestions.vehiclerentalsystem.strategy.CarPricingStrategy();
            case BIKE:
                return new com.interviewQuestions.vehiclerentalsystem.strategy.BikePricingStrategy();
            default:
                return new com.interviewQuestions.vehiclerentalsystem.strategy.TruckPricingStrategy();
        }
    }

    // ---------------------------------
    // Make Payment
    // ---------------------------------

    public void makePayment(
            Bill bill,
            Payment payment) {

        payment.payBill(bill);
    }

    // ---------------------------------
    // Pickup Vehicle
    // ---------------------------------

    public void pickupVehicle(
            Reservation reservation) {

        reservation.setStatus(
                ReservationStatus.IN_PROGRESS);

        reservation
                .getVehicle()
                .setStatus(
                        VehicleStatus.RENTED);

        System.out.println(
                "Vehicle picked up successfully");
    }

    // ---------------------------------
    // Return Vehicle
    // ---------------------------------

    public void returnVehicle(
            Reservation reservation) {

        reservation.setStatus(
                ReservationStatus.COMPLETED);

        reservation
                .getVehicle()
                .setStatus(
                        VehicleStatus.AVAILABLE);

        System.out.println(
                "Vehicle returned successfully");
    }
}