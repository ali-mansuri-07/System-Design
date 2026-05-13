package com.openClosePrinciple;

public class FileInvoiceSaver implements InvoiceSaver {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to file...");
    }
}
