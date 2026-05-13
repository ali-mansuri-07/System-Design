package com.singleresponsibilityprinciple;

// Main class to demonstrate the Single Responsibility Principle (SRP)
// Main — wiring it all together
public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Laptop", 2, 45000);

        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.print();
        // ---- Invoice ----
        // Item    : Laptop
        // Qty     : 2
        // Total   : Rs.90000.0
        // -----------------

        InvoiceRepository repo = new InvoiceRepository(invoice);
        repo.save();
        // Saving [Laptop] to database...
    }
}