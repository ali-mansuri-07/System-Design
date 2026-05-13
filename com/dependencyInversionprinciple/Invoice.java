package com.dependencyInversionprinciple;

public class Invoice {
    public Invoice() {
        System.out.println("Invoice created.");
    }

    public Invoice(String name, int amount) {
        System.out.println("Invoice created with details: " + name + ", " + amount);
    }
}
