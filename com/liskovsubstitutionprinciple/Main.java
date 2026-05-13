package com.liskovsubstitutionprinciple;

// Main class to demonstrate the Liskov Substitution Principle (LSP)
public class Main {
    public static void main(String[] args) {
        // Invoice invoice = new Invoice(100);
        // System.out.println("Invoice amount: " + invoice.amount);
        // System.out.println("Discount: " + invoice.calculateDiscount()); // Works fine

        // Invoice invoice2 = new FixedInvoice(200);
        // System.out.println("Invoice2 amount: " + invoice2.amount);
        // System.out.println("Discount: " + invoice2.calculateDiscount()); //Runtime error due to LSP violation

        Invoice invoice1 = new RegularInvoice(1000);
        Invoice invoice2 = new FixedInvoice(1000);
        System.out.println("Invoice amount: " + invoice1.getAmount());
        System.out.println("Invoice amount: " + invoice2.getAmount());
        Discountable invoice = new RegularInvoice(1000);
        System.out.println(invoice.calculateDiscount());
        
    }
}
