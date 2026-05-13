package com.dependencyInversionprinciple;

public class DatabaseRepository implements InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Saving to DB...");
    }
}
