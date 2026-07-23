package com.interviewQuestions.atm;

import com.interviewQuestions.atm.entities.BankAccount;
import com.interviewQuestions.atm.entities.Card;
import com.interviewQuestions.atm.entities.User;

public class ATMTest {

    static ATM atm;
    static User user1, user2;

    static void setup() {
        atm = new ATM();

        // Create bank accounts
        BankAccount acc1 = new BankAccount("ACC001", 10000);
        BankAccount acc2 = new BankAccount("ACC002", 500);
        atm.registerAccount("ACC001", acc1);
        atm.registerAccount("ACC002", acc2);

        // Create cards
        Card card1 = new Card("4111-1111-1111-1111", 1234, "ACC001");
        Card card2 = new Card("4222-2222-2222-2222", 5678, "ACC002");

        // Create users
        user1 = new User("Rahul", card1, acc1);
        user2 = new User("Priya", card2, acc2);
    }

    // ── Test 1: Happy path — successful withdrawal ─────────
    static void testSuccessfulWithdrawal() {
        System.out.println("\n====== TEST 1: Successful Withdrawal Rs.3600 ======");
        setup();

        atm.insertCard(user1.getCard());
        // Card inserted: 4111-1111-1111-1111

        atm.authenticate(1234);
        // PIN verified. Authentication successful.

        atm.selectOperation("WITHDRAW");
        // Operation selected: WITHDRAW

        atm.withdraw(3600);

    }

    // ── Test 2: Check balance ─────────────────────────────
    static void testCheckBalance() {
        System.out.println("\n====== TEST 2: Check Balance ======");
        setup();

        atm.insertCard(user1.getCard());
        atm.authenticate(1234);
        atm.selectOperation("BALANCE");
        // Available Balance: Rs.10000.0
        // Card ejected.
    }

    // ── Test 3: Wrong PIN then correct PIN ────────────────
    static void testWrongPinThenCorrect() {
        System.out.println("\n====== TEST 3: Wrong PIN then Correct PIN ======");
        setup();

        atm.insertCard(user1.getCard());
        atm.authenticate(9999); // wrong
        // Wrong PIN. Attempt 1 of 3

        atm.authenticate(8888); // wrong again
        // Wrong PIN. Attempt 2 of 3

        atm.authenticate(1234); // correct
        // PIN verified. Authentication successful.

        atm.selectOperation("BALANCE");
        // Available Balance: Rs.10000.0
    }

    // ── Test 4: Card blocked after 3 wrong PINs ───────────
    static void testCardBlocked() {
        System.out.println("\n====== TEST 4: Card Blocked ======");
        setup();

        atm.insertCard(user1.getCard());
        atm.authenticate(1111); // wrong
        atm.authenticate(2222); // wrong
        atm.authenticate(3333); // wrong — BLOCKED!
        // Card blocked! Too many wrong attempts.
        // Card ejected.

        // ATM back to idle — next user can go
        atm.insertCard(user2.getCard());
        atm.authenticate(5678);
        atm.selectOperation("BALANCE");
        // Available Balance: Rs.500.0
    }

    // ── Test 5: Insufficient bank balance ─────────────────
    static void testInsufficientBankBalance() {
        System.out.println("\n====== TEST 5: Insufficient Bank Balance ======");
        setup();

        atm.insertCard(user2.getCard()); // Priya — only Rs.500 balance
        atm.authenticate(5678);
        atm.selectOperation("WITHDRAW");
        atm.withdraw(2000);
        // Insufficient bank balance!
        // Card ejected.
    }

    // ── Test 6: Operations before inserting card ──────────
    static void testOperationsWithoutCard() {
        System.out.println("\n====== TEST 6: Operations Without Card ======");
        setup();

        atm.authenticate(1234);
        // Please insert card first.

        atm.withdraw(500);
        // Please insert card first.

        atm.checkBalance();
        // Please insert card first.
    }

    // ── Test 7: Manual eject mid-session ──────────────────
    static void testManualEject() {
        System.out.println("\n====== TEST 7: Manual Eject Mid-Session ======");
        setup();

        atm.insertCard(user1.getCard());
        atm.authenticate(1234);
        // Authenticated...

        atm.ejectCard(); // user cancels
        // Session ended. Card ejected.

        // Machine back to idle
        atm.checkBalance();
        // Please insert card first.
    }

    // ── Test 8: ATM insufficient cash ─────────────────────
    static void testATMInsufficientCash() {
        System.out.println("\n====== TEST 8: ATM Insufficient Cash ======");

        atm = new ATM();
        // Start with very little cash
        BankAccount richUser = new BankAccount("ACC999", 1000000);
        atm.registerAccount("ACC999", richUser);
        Card richCard = new Card("9999-9999-9999-9999", 0000, "ACC999");
        atm.refillCash(100, 1); // only one Rs.100 note!

        atm.insertCard(richCard);
        atm.authenticate(0000);
        atm.selectOperation("WITHDRAW");
        atm.withdraw(50000);
        // ATM does not have sufficient cash!
        // Card ejected.
    }

    // ── Run all ───────────────────────────────────────────
    public static void main(String[] args) {
        testSuccessfulWithdrawal();
        testCheckBalance();
        testWrongPinThenCorrect();
        testCardBlocked();
        testInsufficientBankBalance();
        testOperationsWithoutCard();
        testManualEject();
        testATMInsufficientCash();

        System.out.println("\n====== All tests complete ======");
    }
}