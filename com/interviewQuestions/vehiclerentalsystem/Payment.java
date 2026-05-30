package com.interviewQuestions.vehiclerentalsystem;

public class Payment {
    public void payBill(Bill bill){
        // process payment
        System.out.println("Payment processed for bill: " + bill.reservation.reservationId);
    }
}