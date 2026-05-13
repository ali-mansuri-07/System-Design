package com.openClosePrinciple;

public class CloudInvoiceSaver implements InvoiceSaver {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to cloud...");
    }
}
