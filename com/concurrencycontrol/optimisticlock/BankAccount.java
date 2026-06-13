package com.concurrencycontrol.optimisticlock;

class BankAccount {
    private String accountId;
    private double balance;
    private int version;    // the key field for optimistic locking

    BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance   = balance;
        this.version   = 1;
    }

    public String getAccountId() { return accountId; }
    public double getBalance()   { return balance; }
    public int    getVersion()   { return version; }

    // No lock — just update balance and version if version still matches
    public boolean withdraw(double amount, int expectedVersion) {
        // Version check — optimistic conflict detection
        if (this.version != expectedVersion) {
            System.out.println("Version mismatch! Expected v" + expectedVersion +
                               " but found v" + this.version + " → retry needed");
            return false;  // caller must retry
        }

        if (this.balance < amount) {
            System.out.println("Insufficient funds!");
            return false;
        }

        this.balance -= amount;
        this.version++;   // increment version on every successful write
        System.out.println("Withdrew Rs." + amount +
                           " | New balance: Rs." + balance +
                           " | Version: v" + version);
        return true;
    }
}