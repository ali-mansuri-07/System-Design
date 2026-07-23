package com.interviewQuestions.atm;

import java.util.HashMap;
import java.util.Map;

import com.interviewQuestions.atm.entities.BankAccount;
import com.interviewQuestions.atm.entities.Card;
import com.interviewQuestions.atm.processors.CashWithdrawalProcessor;
import com.interviewQuestions.atm.processors.FiveHundredNoteProcessor;
import com.interviewQuestions.atm.processors.HundredNoteProcessor;
import com.interviewQuestions.atm.processors.TwoThousandNoteProcessor;
import com.interviewQuestions.atm.states.ATMState;
import com.interviewQuestions.atm.states.AuthenticatedState;
import com.interviewQuestions.atm.states.CashWithdrawalState;
import com.interviewQuestions.atm.states.CheckBalanceState;
import com.interviewQuestions.atm.states.HasCardState;
import com.interviewQuestions.atm.states.IdleState;
import com.interviewQuestions.atm.states.SelectOperationState;

public class ATM {

    // All possible states
    private ATMState idleState;
    private ATMState hasCardState;
    private ATMState authenticatedState;
    private ATMState selectOperationState;
    private ATMState cashWithdrawalState;
    private ATMState checkBalanceState;

    // Current active state
    private ATMState currentState;

    // Transaction context
    private Card currentCard;
    private BankAccount currentAccount;

    // Resources
    private CashInventory cashInventory;
    private CashWithdrawalProcessor cashProcessor;

    // Simulated bank database
    private Map<String, BankAccount> bankDatabase = new HashMap<>();

    public ATM() {
        // Initialize states
        idleState = new IdleState();
        hasCardState = new HasCardState();
        authenticatedState = new AuthenticatedState();
        selectOperationState = new SelectOperationState();
        cashWithdrawalState = new CashWithdrawalState();
        checkBalanceState = new CheckBalanceState();

        // Start in Idle
        currentState = idleState;
        cashInventory = new CashInventory();

        // Build Chain of Responsibility
        // 2000 → 500 → 100
        CashWithdrawalProcessor handler2000 = new TwoThousandNoteProcessor(cashInventory);
        CashWithdrawalProcessor handler500 = new FiveHundredNoteProcessor(cashInventory);
        CashWithdrawalProcessor handler100 = new HundredNoteProcessor(cashInventory);

        handler2000.setNext(handler500);
        handler500.setNext(handler100);

        cashProcessor = handler2000; // entry point of the chain

        System.out.println("ATM initialized and ready.");
    }

    // ── Public operations (delegated to current state) ─────

    public synchronized void insertCard(Card card) {
        currentState.insertCard(this, card);
    }

    public synchronized void authenticate(int pin) {
        currentState.authenticate(this, pin);
    }

    public synchronized void selectOperation(String operation) {
        currentState.selectOperation(this, operation);
    }

    public synchronized void withdraw(double amount) {
        currentState.withdraw(this, amount);
    }

    public synchronized void checkBalance() {
        currentState.checkBalance(this);
    }

    public synchronized void ejectCard() {
        currentState.ejectCard(this);
    }

    // ── Admin operations ───────────────────────────────────

    public void refillCash(int denomination, int count) {
        cashInventory.addNotes(denomination, count);
    }

    public void registerAccount(String accountId, BankAccount account) {
        bankDatabase.put(accountId, account);
    }

    public void displayStatus() {
        System.out.println("\n=== ATM Status ===");
        System.out.println("State: " + currentState.getClass().getSimpleName());
        cashInventory.displayInventory();
        System.out.println("==================\n");
    }

    // ── Internal helpers (used by states) ──────────────────

    public BankAccount getAccountForCard(Card card) {
        return bankDatabase.get(card.getAccountId());
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentAccount(BankAccount acct) {
        this.currentAccount = acct;
    }

    public BankAccount getCurrentAccount() {
        return currentAccount;
    }

    public CashInventory getCashInventory() {
        return cashInventory;
    }

    public CashWithdrawalProcessor getCashProcessor() {
        return cashProcessor;
    }

    // State getters
    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getAuthenticatedState() {
        return authenticatedState;
    }

    public ATMState getSelectOperationState() {
        return selectOperationState;
    }

    public ATMState getCashWithdrawalState() {
        return cashWithdrawalState;
    }

    public ATMState getCheckBalanceState() {
        return checkBalanceState;
    }
}