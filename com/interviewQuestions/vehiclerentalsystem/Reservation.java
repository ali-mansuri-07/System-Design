package com.interviewQuestions.vehiclerentalsystem;

import java.time.LocalDate;

import com.interviewQuestions.vehiclerentalsystem.enums.ReservationStatus;

public class Reservation {
    String reservationId;
    User user;
    Vehicle vehicle;
    LocalDate fromDate;
    LocalDate toDate;
    ReservationStatus status;

    public Reservation(String reservationId, User user, Vehicle vehicle, LocalDate fromDate, LocalDate toDate) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = ReservationStatus.CREATED;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setStatus(
            ReservationStatus status) {
        this.status = status;
    }

}
