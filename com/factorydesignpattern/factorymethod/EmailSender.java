package com.factorydesignpattern.factorymethod;

// Step 2 — Concrete Creators
// Each subclass knows exactly what to create

class EmailSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new EmailNotification();  // EmailSender creates Email
    }
}
