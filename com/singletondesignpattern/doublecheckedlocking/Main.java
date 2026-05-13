package com.singletondesignpattern.doublecheckedlocking;

// BEST — Double-Checked Locking Singleton
class DatabaseConnection {

    // volatile ensures visibility across threads
    private static volatile DatabaseConnection instance = null;

    private DatabaseConnection() {
        System.out.println("DB Connection established!");
    }

    public static DatabaseConnection getInstance() {

        // First check — no locking needed if already created
        if (instance == null) {

            // Lock only when instance might not exist yet
            synchronized (DatabaseConnection.class) {

                // Second check — in case another thread
                // created it while we were waiting for the lock
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;  // fast path — no lock needed
    }

    public void query(String sql) {
        System.out.println("Running query: " + sql);
    }
}

// Main class to demonstrate the Double-Checked Locking Singleton pattern implementation
public class Main {
    public static void main(String[] args) {

        // Simulating multiple threads requesting the instance
        DatabaseConnection c1 = DatabaseConnection.getInstance();
        // DB Connection established!  ← printed only ONCE ever

        DatabaseConnection c2 = DatabaseConnection.getInstance();
        // nothing printed — same instance returned

        DatabaseConnection c3 = DatabaseConnection.getInstance();
        // nothing printed — same instance returned

        // All three are exactly the same object
        System.out.println(c1 == c2); // true
        System.out.println(c2 == c3); // true
        System.out.println(c1 == c3); // true

        c1.query("SELECT * FROM orders");
        // Running query: SELECT * FROM orders
    }
}