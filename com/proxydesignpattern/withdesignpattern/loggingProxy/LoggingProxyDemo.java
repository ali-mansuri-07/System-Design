package com.proxydesignpattern.withdesignpattern.loggingProxy;

// Main class for demonstrating the logging proxy design pattern
public class LoggingProxyDemo {
    public static void main(String[] args) {
        PaymentService paymentService = new LoggingPaymentProxy();
        paymentService.processPayment("Alice", 100.0);
    }
}