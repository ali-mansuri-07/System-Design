package com.interviewQuestions.vendingmachine;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price must be positive");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (Rs." + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product p = (Product) o;
        return name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}