package com.interviewQuestions.atm.entities;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean debit(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient bank balance!");
            return false;
        }
        balance -= amount;
        System.out.println("Account debited: Rs." + amount +
                " | Remaining balance: Rs." + balance);
        return true;
    }
}