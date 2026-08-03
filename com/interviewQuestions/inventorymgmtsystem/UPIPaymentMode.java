package com.interviewQuestions.inventorymgmtsystem;

public class UPIPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Payment of amount " + amount + " made successfully using UPI.");
        return true;
    }
}
