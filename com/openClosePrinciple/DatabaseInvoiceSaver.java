package com.openClosePrinciple;

public class DatabaseInvoiceSaver implements InvoiceSaver {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to DB...");
    }
}