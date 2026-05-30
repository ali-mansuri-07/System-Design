package com.interviewQuestions.vehiclerentalsystem;

import java.time.LocalDate;
import java.util.List;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;

public class Main {

    public static void main(String[] args) {
        VehicleRentalSystem rentalSystem = VehicleRentalSystem.getInstance();

        // Create store and inventory
        Location puneLocation = new Location("123 MG Road", "Pune", "MH", "411001");
        Store puneStore = new Store("S1", puneLocation);

        Vehicle car1 = VehicleFactory.createVehicle(VehicleType.CAR, "C1", "MH12AB1234");
        Vehicle car2 = VehicleFactory.createVehicle(VehicleType.CAR, "C2", "MH12AB5678");
        Vehicle bike1 = VehicleFactory.createVehicle(VehicleType.BIKE, "B1", "MH12XY9876");

        puneStore.getInventoryManager().addVehicle(car1);
        puneStore.getInventoryManager().addVehicle(car2);
        puneStore.getInventoryManager().addVehicle(bike1);

        rentalSystem.addStore(puneStore);

        // Create user
        User user = new User("Aditi Sharma", "U1", "DL-1234567890");
        rentalSystem.addUser(user);

        // Search available cars in Pune
        System.out.println("Searching available cars in Pune...");
        List<Vehicle> availableCars = rentalSystem.searchVehicles("Pune", VehicleType.CAR);

        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent in Pune.");
            return;
        }

        Vehicle selectedCar = availableCars.get(0);
        System.out.println("Selected vehicle: " + selectedCar.vehicleNumber + " (" + selectedCar.vehicleType + ")");

        LocalDate fromDate = LocalDate.now();
        LocalDate toDate = fromDate.plusDays(3);

        Reservation reservation = rentalSystem.reserveVehicle(user, selectedCar, fromDate, toDate);
        System.out.println("Reservation created: " + reservation.reservationId);
        System.out.println("Vehicle status after reservation: " + selectedCar.getStatus());

        Bill bill = rentalSystem.generateBill(reservation);
        System.out.println("Bill generated for reservation " + reservation.reservationId + ": " + bill.amount);

        Payment payment = new Payment();
        rentalSystem.makePayment(bill, payment);

        rentalSystem.pickupVehicle(reservation);
        System.out.println("Reservation status after pickup: " + reservation.status);
        System.out.println("Vehicle status after pickup: " + selectedCar.getStatus());

        rentalSystem.returnVehicle(reservation);
        System.out.println("Reservation status after return: " + reservation.status);
        System.out.println("Vehicle status after return: " + selectedCar.getStatus());
    }
}
