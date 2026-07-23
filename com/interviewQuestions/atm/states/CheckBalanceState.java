package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.Card;

public class CheckBalanceState implements ATMState {

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
        System.out.println("Currently checking balance.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Wrong operation — currently in balance check mode.");
    }

    @Override
    public void checkBalance(ATM atm) {
        double balance = atm.getCurrentAccount().getBalance();
        System.out.println("Available Balance: Rs." + balance);
        ejectCard(atm);
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected.");
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
    }
}