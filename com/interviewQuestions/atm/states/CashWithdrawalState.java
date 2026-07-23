package com.interviewQuestions.atm.states;

import com.interviewQuestions.atm.ATM;
import com.interviewQuestions.atm.entities.BankAccount;
import com.interviewQuestions.atm.entities.Card;

public class CashWithdrawalState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void authenticate(ATM atm, int pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void selectOperation(ATM atm, String operation) {
        System.out.println("Already in withdrawal. Please complete.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        BankAccount account = atm.getCurrentAccount();

        // Check ATM has enough physical cash
        if (!atm.getCashInventory().hasSufficientCash(amount)) {
            System.out.println("ATM does not have sufficient cash!");
            ejectCard(atm);
            return;
        }

        // Check user's bank balance
        if (!account.debit(amount)) {
            System.out.println("Insufficient bank balance!");
            ejectCard(atm);
            return;
        }

        // Dispense cash via Chain of Responsibility
        System.out.println("Dispensing Rs." + amount + "...");
        atm.getCashProcessor().withdraw((int) amount);

        System.out.println("Please collect your cash.");
        ejectCard(atm);
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Wrong operation — currently in withdrawal mode.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Transaction complete. Card ejected.");
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
    }
}