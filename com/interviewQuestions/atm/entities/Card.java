package com.interviewQuestions.atm.entities;

public class Card {
    private String cardNumber;
    private int    pin;
    private String accountId;

    public Card(String cardNumber, int pin, String accountId) {
        this.cardNumber = cardNumber;
        this.pin        = pin;
        this.accountId  = accountId;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public String getCardNumber() { return cardNumber; }
    public String getAccountId()  { return accountId; }
}