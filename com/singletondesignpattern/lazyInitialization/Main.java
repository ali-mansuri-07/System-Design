package com.singletondesignpattern.lazyInitialization;

// Lazy Singleton — NOT thread safe!
class DatabaseConnection {

    // Not initialized yet — starts as null
    private static DatabaseConnection instance = null;

    private DatabaseConnection() {
        System.out.println("DB Connection established!");
    }

    public static DatabaseConnection getInstance() {
        // Only create if it doesn't exist yet
        if (instance == null) {
            instance = new DatabaseConnection(); // created on first call
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Running query: " + sql);
    }
}

// Main class to demonstrate the problem of multiple instances without Singleton
// Lazy Initialization — NOT thread safe!
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