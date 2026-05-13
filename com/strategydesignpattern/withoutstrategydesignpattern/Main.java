package com.strategydesignpattern.withoutstrategydesignpattern;

class ShoppingCart {

    public void checkout(String paymentType, int amount) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Paid " + amount + " using Credit Card");

        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Paid " + amount + " using PayPal");

        } else if (paymentType.equals("UPI")) {
            System.out.println("Paid " + amount + " using UPI");

        } else {
            throw new IllegalArgumentException("Invalid payment method");
        }
    }
}

// Main class to demonstrate the problem of tight coupling without Strategy Design Pattern
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.checkout("CREDIT_CARD", 100);
        cart.checkout("PAYPAL", 200);
    }
}

