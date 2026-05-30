# Vehicle Rental System — Design Overview

This document explains the architecture, key entities, design patterns, and runtime flows for the sample Vehicle Rental System located in the `com.interviewQuestions.vehiclerentalsystem` package.

**Goal**
- Provide a small, extensible in-memory demo for searching, reserving, billing, paying for, picking up, and returning vehicles.

**Core Entities**
- `VehicleRentalSystem` — Singleton coordinator for stores, users, reservations, billing, and lifecycle operations.
- `Store` — Represents a location with a `Location` object and a `VehicleInventoryManager`.
- `Vehicle` (abstract) — Base class for `Car` and `Bike` with `vehicleId`, `vehicleNumber`, `vehicleType`, and `status`.
- `VehicleInventoryManager` — Manages vehicle storage and availability queries.
- `User` — Basic profile used for reservations.
- `Reservation` — Links `User`, `Vehicle`, and the rental period with a `ReservationStatus`.
- `Bill` / `Payment` — Simple billing and payment delegation objects.
- `PricingStrategy` + implementations — Strategy interface and concrete classes (`CarPricingStrategy`, `BikePricingStrategy`, `TruckPricingStrategy`) encapsulate pricing rules.
- `VehicleFactory` — New factory that centralizes `Vehicle` creation.

**Design Patterns Used**
- Singleton: `VehicleRentalSystem.getInstance()` ensures a single in-memory system instance.
- Strategy: `PricingStrategy` implementations encapsulate rate calculations and are swappable.
- Factory: `VehicleFactory.createVehicle(...)` centralizes vehicle instantiation.
- Composition: `Store` composes `VehicleInventoryManager` to separate concerns.
- SOLID principles: small focused classes, open for extension via strategies and factories.

**Main Runs & Flows (Search → Reserve → Bill → Pay → Pickup → Return)**
1. Search: `VehicleRentalSystem.searchVehicles(city, vehicleType)` finds a `Store` by city and returns available vehicles.
2. Reserve: `VehicleRentalSystem.reserveVehicle(user, vehicle, fromDate, toDate)` creates `Reservation`, marks vehicle `RESERVED`.
3. Billing: `VehicleRentalSystem.generateBill(reservation)` auto-selects a `PricingStrategy` based on the vehicle type and computes amount.
4. Payment: `VehicleRentalSystem.makePayment(bill, payment)` delegates to `Payment.payBill(bill)`.
5. Pickup: `VehicleRentalSystem.pickupVehicle(reservation)` sets `IN_PROGRESS` and marks vehicle `RENTED`.
6. Return: `VehicleRentalSystem.returnVehicle(reservation)` marks `COMPLETED` and sets vehicle `AVAILABLE`.

**How Pricing Strategy is Selected**
- The system automatically chooses the appropriate `PricingStrategy` implementation inside `VehicleRentalSystem.generateBill(...)` using the `vehicleType` on the reservation's vehicle. This keeps callers (UI/tests) free from pricing concerns.

**Usage / Run**
From the project root (`D:\System Design\LLD\Implementation`):
```bash
javac com\interviewQuestions\vehiclerentalsystem\*.java com\interviewQuestions\vehiclerentalsystem\strategy\*.java
java -cp . com.interviewQuestions.vehiclerentalsystem.Main
```
