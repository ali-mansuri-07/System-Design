package com.proxydesignpattern.withdesignpattern.loggingProxy;

class RealPaymentService implements PaymentService {
    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Processing payment: $"
                         + amount + " for " + account);
    }
}