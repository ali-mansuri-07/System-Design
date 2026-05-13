package com.proxydesignpattern.withdesignpattern.loggingProxy;

interface PaymentService {
    void processPayment(String account, double amount);
}