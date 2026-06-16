package com.interviewQuestions.vendingmachine;

// Inventory.java
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> stock = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
        System.out.println("Stocked: " + product + " x" + quantity);
    }

    public boolean isAvailable(Product product) {
        return stock.getOrDefault(product, 0) > 0;
    }

    public void dispense(Product product) {
        if (!isAvailable(product))
            throw new IllegalStateException("Product out of stock: " + product.getName());
        stock.put(product, stock.get(product) - 1);
    }

    public int getQuantity(Product product) {
        return stock.getOrDefault(product, 0);
    }

    public void displayStock() {
        System.out.println("=== Current Stock ===");
        stock.forEach((p, q) -> System.out.println("  " + p + " → qty: " + q));
    }
}