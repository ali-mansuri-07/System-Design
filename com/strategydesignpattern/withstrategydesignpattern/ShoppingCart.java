package com.strategydesignpattern.withstrategydesignpattern;

//Context: This is the ShoppingCart class that uses the PaymentStrategy interface to allow for different payment methods. The setPaymentStrategy method allows the client to choose which payment method to use at runtime, and the checkout method calls the pay method of the chosen strategy to process the payment.
class ShoppingCart {
    //This payment strategy can change at runtime to be CreditCardPayment, PayPalPayment, UpiPayment, etc.
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        strategy.pay(amount);
    }
}
