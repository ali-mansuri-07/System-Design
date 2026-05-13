package com.singletondesignpattern.eagerInitialization;

// Eager Singleton
class DatabaseConnection {

    // Instance created immediately at class load time
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    // Private constructor — prevents new DatabaseConnection()
    private DatabaseConnection() {
        System.out.println("DB Connection established!");
    }

    // Only way to get the instance
    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }

    public void query(String sql) {
        System.out.println("Running query: " + sql);
    }
}

// Main class to demonstrate the Eager Initialization Singleton pattern implementation
public class Main {
    public static void main(String[] args) {
        DatabaseConnection c1 = DatabaseConnection.getInstance();
        DatabaseConnection c2 = DatabaseConnection.getInstance();
        DatabaseConnection c3 = DatabaseConnection.getInstance();

        System.out.println(c1 == c2); // true — same object!
        System.out.println(c2 == c3); // true — always the same!

        c1.query("SELECT * FROM users");
        // Running query: SELECT * FROM users
    }
}