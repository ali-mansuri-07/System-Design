package com.liskovsubstitutionprinciple;

//Problem
/*
//Parent class 
class Invoice {
    protected double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double calculateDiscount() {
        return amount * 0.1; // 10% discount
    }
}
*/

//Solution
interface Invoice {
    double getAmount();
}