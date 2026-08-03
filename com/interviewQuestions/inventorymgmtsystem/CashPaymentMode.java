package com.interviewQuestions.inventorymgmtsystem;

public class CashPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Payment of amount " + amount + " made successfully using Cash.");
        return true;
    }

}
