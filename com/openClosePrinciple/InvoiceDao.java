package com.openClosePrinciple;

//Old code that violates Open/Closed Principle
// This class violates the Open/Closed Principle because it has to be modified to add new saving methods (e.g., saveToCloud)

/*
    public class InvoiceDao {
        Invoice invoice;
        public InvoiceDao(Invoice invoice) {
            this.invoice = invoice;
        }
        public void saveToDatabase() {
            System.out.println("Saving invoice to DB...");
            // database code here
        }
        public void saveToFile() {
            System.out.println("Saving invoice to file...");
            // file I/O code here
        }

    }
*/

//New code that adheres to Open/Closed Principle
public class InvoiceDao {
    private InvoiceSaver saver;

    public InvoiceDao(InvoiceSaver saver) {
        this.saver = saver;
    }

    public void save(Invoice invoice) {
        saver.save(invoice);
    }
}
