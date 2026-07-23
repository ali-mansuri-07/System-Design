package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.Card;

public interface ATMState {
    void insertCard(ATM atm, Card card);
    void authenticate(ATM atm, int pin);
    void selectOperation(ATM atm, String operation);
    void withdraw(ATM atm, double amount);
    void checkBalance(ATM atm);
    void ejectCard(ATM atm);
}