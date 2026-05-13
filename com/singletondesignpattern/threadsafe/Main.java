package com.singletondesignpattern.threadsafe;

// Thread-safe but slow Singleton
class DatabaseConnection {

    private static DatabaseConnection instance = null;

    private DatabaseConnection() {
        System.out.println("DB Connection established!");
    }

    // synchronized — only one thread can enter at a time
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Running query: " + sql);
    }
}

// Main class to demonstrate the thread-safe Singleton pattern implementation
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