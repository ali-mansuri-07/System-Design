package com.proxydesignpattern.withdesignpattern.loggingProxy;


// Logging Proxy — logs every call
class LoggingPaymentProxy implements PaymentService {
    private RealPaymentService service;

    public LoggingPaymentProxy() {
        this.service = new RealPaymentService();
    }

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("[LOG] Payment requested: "
                         + account + " $" + amount);
        long start = System.currentTimeMillis();

        service.processPayment(account, amount);

        long end = System.currentTimeMillis();
        System.out.println("[LOG] Payment completed in "
                         + (end - start) + "ms");
    }
}