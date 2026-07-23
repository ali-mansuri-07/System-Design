package com.interviewQuestions.atm.entities;

public class User {
    private String name;
    private Card card;
    private BankAccount account;

    public User(String name, Card card, BankAccount account) {
        this.name = name;
        this.card = card;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    public BankAccount getAccount() {
        return account;
    }
}