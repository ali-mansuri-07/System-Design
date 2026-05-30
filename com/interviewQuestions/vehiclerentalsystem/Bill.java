package com.interviewQuestions.vehiclerentalsystem;

public class Bill {
    Reservation reservation;
    double amount;
    public Bill(Reservation reservation, double amount) {
        this.reservation = reservation;
        this.amount = amount;
    }
}