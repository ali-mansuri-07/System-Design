package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.Card;

public class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        atm.setCurrentCard(card);
        System.out.println("Card inserted: " + card.getCardNumber());
        atm.setState(atm.getHasCardState()); // transition
    }

    @Override
    public void authenticate(ATM atm, int pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void selectOperation(ATM atm, String operation) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("No card inserted.");
    }
}