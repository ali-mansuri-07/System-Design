package com.interviewQuestions.bookmyshow.entities;

import java.util.UUID;

import com.interviewQuestions.bookmyshow.enums.PaymentStatus;

public class Payment {
    private final UUID paymentId;
    private final double amount;
    private final PaymentStatus paymentStatus;

    public Payment(double amount, PaymentStatus paymentStatus) {
        this.paymentId = UUID.randomUUID();
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public UUID getPaymentId() {
        return paymentId;
    }
    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
