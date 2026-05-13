package com.observerdesignpattern.withoutObserverPattern;

public class InvoiceService {
    void generateInvoice(String item) {
        System.out.println("Invoice generated for [" + item + "]");
    }
}
