package com.liskovsubstitutionprinciple;

class RegularInvoice implements Invoice, Discountable {
    private double amount;

    public RegularInvoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double calculateDiscount() {
        return amount * 0.1;
    }
}