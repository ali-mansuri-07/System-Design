package com.concurrencycontrol.pessimisticlock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount("ACC-001", 500);

        // Two threads trying to withdraw simultaneously
        Thread userA = new Thread(() -> account.withdraw("User A", 200));
        Thread userB = new Thread(() -> account.withdraw("User B", 300));

        userA.start();
        userB.start();

        userA.join();
        userB.join();

        System.out.println("Final balance: Rs." + account.getBalance());
        // User A trying to withdraw Rs.200.0 | Current balance: Rs.500.0
        // User A withdrew Rs.200.0 | New balance: Rs.300.0
        // User B trying to withdraw Rs.300.0 | Current balance: Rs.300.0
        // User B withdrew Rs.300.0 | New balance: Rs.0.0
        // Final balance: Rs.0.0 ✓ correct!
    }
}