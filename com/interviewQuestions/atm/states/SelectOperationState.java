package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.Card;

public class SelectOperationState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Session in progress.");
    }

    @Override
    public void authenticate(ATM atm, int pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void selectOperation(ATM atm, String operation) {
        switch (operation.toUpperCase()) {
            case "WITHDRAW":
                atm.setState(atm.getCashWithdrawalState());
                System.out.println("Please enter amount to withdraw.");
                break;
            case "BALANCE":
                atm.setState(atm.getCheckBalanceState());
                atm.getCurrentState().checkBalance(atm);
                break;
            default:
                System.out.println("Unknown operation: " + operation);
        }
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please select WITHDRAW operation first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please select BALANCE operation first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected.");
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
    }
}