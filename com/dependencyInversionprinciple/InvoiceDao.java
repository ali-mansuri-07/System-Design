package com.dependencyInversionprinciple;

public class InvoiceDao {
    private Database database;

    public InvoiceDao() {
        this.database = new Database(); // ❌ tightly coupled
    }

    public void save(Invoice invoice) {
        database.save(invoice);
    }
}