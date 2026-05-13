package com.interfacesegregationprinciple;

public class PremiumInvoice implements Saveable, Printable, Discountable {

    public void saveInvoice() {
        System.out.println("Saving invoice...");
    }

    public void printInvoice() {
        System.out.println("Printing invoice...");
    }

    public void calculateDiscount() {
        System.out.println("Calculating discount...");
    }
}
