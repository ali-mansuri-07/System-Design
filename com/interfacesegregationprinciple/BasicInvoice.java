package com.interfacesegregationprinciple;

public class BasicInvoice implements InvoiceService {

    public void saveInvoice() {
        System.out.println("Saving invoice...");
    }

    public void printInvoice() {
        System.out.println("Printing invoice...");
    }

    public void calculateDiscount() {
        throw new UnsupportedOperationException("No discount"); // This violates ISP because BasicInvoice doesn't need to implement calculateDiscount
    }
}