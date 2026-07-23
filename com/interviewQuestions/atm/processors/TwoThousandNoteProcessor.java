package com.interviewQuestions.atm.processors;

import com.interviewQuestions.atm.CashInventory;

public class TwoThousandNoteProcessor implements CashWithdrawalProcessor {
    private CashWithdrawalProcessor next;
    private CashInventory inventory;

    public TwoThousandNoteProcessor(CashInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void setNext(CashWithdrawalProcessor next) {
        this.next = next;
    }

    @Override
    public void withdraw(int amount) {
        int noteCount = amount / 2000;
        int available = inventory.getNoteCount(2000);
        int toDispense = Math.min(noteCount, available);

        if (toDispense > 0) {
            inventory.deductNotes(2000, toDispense);
            System.out.println("Dispensing " + toDispense + " x Rs.2000 = Rs." + (toDispense * 2000));
        }

        int remainder = amount - (toDispense * 2000);

        if (remainder > 0 && next != null) {
            next.withdraw(remainder); // pass remainder down the chain
        } else if (remainder > 0) {
            System.out.println("Cannot dispense remaining Rs." + remainder + " — no more handlers!");
        }
    }
}