package com.singleresponsibilityprinciple;

// BAD — violates SRP
// This class has 3 responsibilities crammed into one
/*
class Invoice {
    private String itemName;
    private int quantity;
    private double price;

    Invoice(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Responsibility 1: Business logic
    public double calculateTotal() {
        return quantity * price;
    }

    // Responsibility 2: Presentation — should NOT be here
    public void printInvoice() {
        System.out.println("Item: " + itemName);
        System.out.println("Qty: " + quantity);
        System.out.println("Total: " + calculateTotal());
    }

    // Responsibility 3: Persistence — should NOT be here
    public void saveToDatabase() {
        System.out.println("Saving invoice to DB...");
        // database code here
    }
}

*/

// GOOD — adheres to SRP
// Each class has only one responsibility   
// GOOD — follows SRP

// Class 1: Only business logic
class Invoice {
    private String itemName;
    private int quantity;
    private double price;

    Invoice(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotal() {
        return quantity * price;
    }

    // Getters
    public String getItemName() { return itemName; }
    public int getQuantity()    { return quantity; }
    public double getPrice()    { return price; }
}