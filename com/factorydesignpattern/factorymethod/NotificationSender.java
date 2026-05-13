package com.factorydesignpattern.factorymethod;

// Step 1 — Abstract Creator
// Defines the factory method that subclasses must override
abstract class NotificationSender {

    // THE factory method — subclass decides what to create
    public abstract Notification createNotification();

    // Template method — uses the factory method
    public void sendNotification(String message) {
        // Creates object via factory method (not hardcoded)
        Notification notification = createNotification();
        notification.send(message);
    }
}