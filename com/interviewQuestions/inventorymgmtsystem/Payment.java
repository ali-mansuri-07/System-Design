package com.interviewQuestions.inventorymgmtsystem;

public class Payment {
    PaymentMode paymentMode;

    Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean makePayment(double amount) {
        return paymentMode.makePayment(amount);
    }
}
