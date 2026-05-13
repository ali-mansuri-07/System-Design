package com.proxydesignpattern.withproxydesignpattern.loggingProxy;

interface PaymentService {
    void processPayment(String account, double amount);
}