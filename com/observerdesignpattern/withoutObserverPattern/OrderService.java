package com.observerdesignpattern.withoutObserverPattern;

// BAD — without Observer pattern
// NotificationService has to manually call every department
// Adding a new department means editing this class — violates OCP!

class OrderService {
    private EmailService emailService = new EmailService("user@example.com");
    private SMSService smsService     = new SMSService("123-456-7890");
    private InvoiceService invoiceService = new InvoiceService();

    public void placeOrder(String item) {
        System.out.println("Order placed for: " + item);

        // Manually notifying each one — tightly coupled!
        emailService.sendEmail(item);
        smsService.sendSMS(item);
        invoiceService.generateInvoice(item);
        // Adding WhatsApp? Must edit OrderService again!
    }
}
