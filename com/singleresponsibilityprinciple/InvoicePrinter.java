package com.singleresponsibilityprinciple;

// Class 2: Only printing responsibility
class InvoicePrinter {
    private Invoice invoice;

    InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        System.out.println("---- Invoice ----");
        System.out.println("Item    : " + invoice.getItemName());
        System.out.println("Qty     : " + invoice.getQuantity());
        System.out.println("Total   : Rs." + invoice.calculateTotal());
        System.out.println("-----------------");
    }
}