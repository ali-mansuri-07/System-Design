package com.dependencyInversionprinciple;

public class FileRepository implements InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Saving to File...");
    }
}