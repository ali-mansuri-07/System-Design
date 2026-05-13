package com.dependencyInversionprinciple;

public class Database {
    public Database() {
        System.out.println("Database initialized.");
    }

    public void save(Invoice invoice) {
        System.out.println("Saving invoice to database...");
    }
}
