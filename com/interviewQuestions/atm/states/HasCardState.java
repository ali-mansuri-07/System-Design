package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.BankAccount;
import com.interviewQuestions.atm.entities.Card;

public class HasCardState implements ATMState {
    private int wrongPinCount = 0;
    private static final int MAX_ATTEMPTS = 3;

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card already inserted. Please complete current session.");
    }

    @Override
    public void authenticate(ATM atm, int pin) {
        Card card = atm.getCurrentCard();

        if (card.validatePin(pin)) {
            System.out.println("PIN verified. Authentication successful.");
            wrongPinCount = 0; // reset for next session
            // Fetch user's bank account
            BankAccount account = atm.getAccountForCard(card);
            atm.setCurrentAccount(account);
            atm.setState(atm.getAuthenticatedState());
        } else {
            wrongPinCount++;
            System.out.println("Wrong PIN. Attempt " + wrongPinCount + " of " + MAX_ATTEMPTS);

            if (wrongPinCount >= MAX_ATTEMPTS) {
                System.out.println("Card blocked! Too many wrong attempts.");
                wrongPinCount = 0;
                ejectCard(atm); // block and eject
            }
        }
    }

    @Override
    public void selectOperation(ATM atm, String operation) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected.");
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
    }
}