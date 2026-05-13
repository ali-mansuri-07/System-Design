package com.strategydesignpattern.withstrategydesignpattern;

// Main class to demonstrate the Strategy Design Pattern implementation
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new UpiPayment());
        cart.checkout(200);
    }
}