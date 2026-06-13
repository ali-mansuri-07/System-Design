package com.concurrencycontrol.pessimisticlock;

class BankAccount {
    private String accountId;
    private double balance;

    BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // synchronized — only one thread can execute this at a time
    // This IS pessimistic locking at the JVM level
    public synchronized void withdraw(String user, double amount) {
        System.out.println(user + " trying to withdraw Rs." + amount +
                " | Current balance: Rs." + balance);

        if (balance < amount) {
            System.out.println(user + ": Insufficient funds!");
            return;
        }

        // Simulate some processing time
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        balance -= amount;
        System.out.println(user + " withdrew Rs." + amount +
                " | New balance: Rs." + balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}