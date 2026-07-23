package com.interviewQuestions.atm.processors;

import com.interviewQuestions.atm.CashInventory;

public class FiveHundredNoteProcessor implements CashWithdrawalProcessor {
    private CashWithdrawalProcessor next;
    private CashInventory inventory;

    public FiveHundredNoteProcessor(CashInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void setNext(CashWithdrawalProcessor next) {
        this.next = next;
    }

    @Override
    public void withdraw(int amount) {
        int noteCount = amount / 500;
        int available = inventory.getNoteCount(500);
        int toDispense = Math.min(noteCount, available);

        if (toDispense > 0) {
            inventory.deductNotes(500, toDispense);
            System.out.println("Dispensing " + toDispense + " x Rs.500 = Rs." + (toDispense * 500));
        }

        int remainder = amount - (toDispense * 500);

        if (remainder > 0 && next != null) {
            next.withdraw(remainder);
        } else if (remainder > 0) {
            System.out.println("Cannot dispense remaining Rs." + remainder);
        }
    }
}