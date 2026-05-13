package com.liskovsubstitutionprinciple;
//Problem 
/*
//Subclass that violates LSP by throwing an exception instead of providing a valid implementation
class FixedInvoice extends Invoice {

    public FixedInvoice(double amount) {
        super(amount);
    }

    @Override
    public double calculateDiscount() {
        throw new UnsupportedOperationException("No discount allowed!");
    }
}
 */

//Solution
class FixedInvoice implements Invoice {
    private double amount;

    public FixedInvoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}