package com.interfacesegregationprinciple;

// Main class to demonstrate the Interface Segregation Principle
public class Main {
    public static void main(String[] args) {
        NormalInvoice invoice = new NormalInvoice();
        invoice.saveInvoice();
        invoice.printInvoice();
        //invoice.calculateDiscount();// This will cause a compile-time error since NormalInvoice does not implement Discountable
        PremiumInvoice premiumInvoice = new PremiumInvoice();
        premiumInvoice.saveInvoice();
        premiumInvoice.printInvoice();
        premiumInvoice.calculateDiscount();
    }
}
