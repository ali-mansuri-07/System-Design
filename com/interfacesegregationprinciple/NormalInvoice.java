package com.interfacesegregationprinciple;

public class NormalInvoice implements Saveable, Printable {

    public void saveInvoice() {
        System.out.println("Saving invoice...");
    }

    public void printInvoice() {
        System.out.println("Printing invoice...");
    }
}