package com.interviewQuestions.atm;

import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    // Key = denomination, Value = count of notes
    private Map<Integer, Integer> notes = new HashMap<>();

    public CashInventory() {
        // Initial ATM load
        notes.put(2000, 10);
        notes.put(500, 20);
        notes.put(100, 50);
    }

    public int getNoteCount(int denomination) {
        return notes.getOrDefault(denomination, 0);
    }

    public void deductNotes(int denomination, int count) {
        int current = notes.getOrDefault(denomination, 0);
        if (count > current)
            throw new IllegalStateException("Not enough " + denomination + " notes!");
        notes.put(denomination, current - count);
    }

    public void addNotes(int denomination, int count) {
        notes.put(denomination, notes.getOrDefault(denomination, 0) + count);
        System.out.println("Refilled: " + count + " x " + denomination + " notes");
    }

    public boolean hasSufficientCash(double amount) {
        double total = notes.entrySet().stream()
                .mapToDouble(e -> (double) e.getKey() * e.getValue())
                .sum();
        return total >= amount;
    }

    public void displayInventory() {
        System.out.println("=== Cash Inventory ===");
        notes.forEach((denom, count) -> System.out.println("  Rs." + denom + " x " + count +
                " = Rs." + (denom * count)));
    }
}
