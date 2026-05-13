package com.openClosePrinciple;

// Main class to demonstrate the Open-Closed Principle (OCP)
public class Main {
    public static void main(String[] args) {

        Invoice invoice = new Invoice("INV001", 10, 5000);

        System.out.println("===== OLD DESIGN (Violates OCP) =====");

        // Old design: tightly coupled, needs modification for new features
        // InvoiceDao oldDao = new InvoiceDao(invoice);
        // oldDao.saveToDatabase();
        // oldDao.saveToFile();

        // Problem: If we want cloud, we must MODIFY InvoiceDaoOld ❌


        System.out.println("\n===== NEW DESIGN (Follows OCP) =====");

        // New design: flexible and extensible

        // Save to DB
        InvoiceSaver dbSaver = new DatabaseInvoiceSaver();
        InvoiceDao newDao1 = new InvoiceDao(dbSaver);
        newDao1.save(invoice);

        // Save to File
        InvoiceSaver fileSaver = new FileInvoiceSaver();
        InvoiceDao newDao2 = new InvoiceDao(fileSaver);
        newDao2.save(invoice);

        // New feature: Cloud (NO modification required ✅)
        InvoiceSaver cloudSaver = new CloudInvoiceSaver();
        InvoiceDao newDao3 = new InvoiceDao(cloudSaver);
        newDao3.save(invoice);
    }
}