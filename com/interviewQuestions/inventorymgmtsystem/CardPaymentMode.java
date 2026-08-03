package com.interviewQuestions.inventorymgmtsystem;

public class CardPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Payment of amount " + amount + " made successfully using Card.");
        return true;
    }

}
