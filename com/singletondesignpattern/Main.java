package com.singletondesignpattern;

class DatabaseConnection {
    public DatabaseConnection() {
        // Expensive operation — opening a DB connection
        System.out.println("New DB connection created!");
    }

    public void query(String sql) {
        System.out.println("Running: " + sql);
    }
}

// Main class to demonstrate the problem of multiple instances without Singleton
public class Main {
    public static void main(String[] args) {
        DatabaseConnection c1 = new DatabaseConnection(); // New connection!
        DatabaseConnection c2 = new DatabaseConnection(); // Another new one!
        DatabaseConnection c3 = new DatabaseConnection(); // Yet another!

        // c1, c2, c3 are all different objects — wasteful and risky
        System.out.println(c1 == c2); // false
    }
}





