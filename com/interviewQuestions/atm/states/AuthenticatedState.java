package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.Card;

// AuthenticatedState.java
public class AuthenticatedState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Session in progress. Please complete and eject first.");
    }

    @Override
    public void authenticate(ATM atm, int pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void selectOperation(ATM atm, String operation) {
        System.out.println("Operation selected: " + operation);
        atm.setState(atm.getSelectOperationState());

        // Immediately delegate to select operation state
        atm.getCurrentState().selectOperation(atm, operation);
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please select operation first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please select operation first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Session ended. Card ejected.");
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
    }
}
