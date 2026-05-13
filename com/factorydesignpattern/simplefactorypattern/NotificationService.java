package com.factorydesignpattern.simplefactorypattern;

// Without Factory Pattern
// BAD — business logic directly creates objects
class NotificationService {
    public void send(String type, String message) {

        // tightly coupled to every notification class
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.send(message);

        } else if (type.equals("SMS")) {
            SMSNotification sms = new SMSNotification();
            sms.send(message);

        } else if (type.equals("PUSH")) {
            PushNotification push = new PushNotification();
            push.send(message);
        }
    }
}