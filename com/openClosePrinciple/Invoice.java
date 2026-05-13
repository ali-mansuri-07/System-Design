package com.openClosePrinciple;

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
