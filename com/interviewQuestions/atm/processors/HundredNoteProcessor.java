package com.interviewQuestions.atm.processors;

import com.interviewQuestions.atm.CashInventory;

public class HundredNoteProcessor implements CashWithdrawalProcessor {
    private CashWithdrawalProcessor next;
    private CashInventory inventory;

    public HundredNoteProcessor(CashInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void setNext(CashWithdrawalProcessor next) {
        this.next = next;
    }

    @Override
    public void withdraw(int amount) {
        int noteCount = amount / 100;
        int available = inventory.getNoteCount(100);
        int toDispense = Math.min(noteCount, available);

        if (toDispense > 0) {
            inventory.deductNotes(100, toDispense);
            System.out.println("Dispensing " + toDispense + " x Rs.100 = Rs." + (toDispense * 100));
        }

        int remainder = amount - (toDispense * 100);

        if (remainder > 0) {
            System.out.println("Cannot dispense Rs." + remainder + " — not a valid denomination combination.");
        }
    }
}
