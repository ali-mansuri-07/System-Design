package com.concurrencycontrol.optimisticlock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount("ACC-001", 500);
        OptimisticLockService service = new OptimisticLockService();

        // Two threads try to withdraw simultaneously
        Thread userA = new Thread(() -> service.withdraw(account, "User A", 200));
        Thread userB = new Thread(() -> service.withdraw(account, "User B", 300));

        userA.start();
        userB.start();

        userA.join();
        userB.join();

        System.out.println("Final balance: Rs." + account.getBalance());

        // User A attempt 1: reading balance=500.0 v=1
        // User B attempt 1: reading balance=500.0 v=1
        // Withdrew Rs.200.0 | New balance: Rs.300.0 | Version: v2
        // User A: Transaction committed successfully!
        // Version mismatch! Expected v1 but found v2 → retry needed
        // User B: Retrying... (attempt 1)
        // User B attempt 2: reading balance=300.0 v=2
        // Withdrew Rs.300.0 | New balance: Rs.0.0 | Version: v3
        // User B: Transaction committed successfully!
        // Final balance: Rs.0.0  ✓ correct!
    }
}
