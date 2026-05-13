package com.dependencyInversionprinciple;

// Main class to demonstrate the Dependency Inversion Principle
public class Main {
    public static void main(String[] args) {

        Invoice invoice = new Invoice("INV001", 5000);

        // Inject DB implementation
        InvoiceRepository dbRepo = new DatabaseRepository();
        InvoiceService service1 = new InvoiceService(dbRepo);
        service1.saveInvoice(invoice);

        // Inject File implementation
        InvoiceRepository fileRepo = new FileRepository();
        InvoiceService service2 = new InvoiceService(fileRepo);
        service2.saveInvoice(invoice);
    }
}