package com.factorydesignpattern.simplefactorypattern;

// Main class to demonstrate the Simple Factory Design Pattern
public class Main {
    public static void main(String[] args) {
        // Without Factory Pattern
        NotificationService service = new NotificationService();
        service.send("EMAIL", "Hello via Email without Factory!");
        service.send("SMS", "Hello via SMS without Factory!");
        service.send("PUSH", "Hello via Push Notification without Factory!");

        // With Factory Pattern
        NotificationFactory factory = new NotificationFactory();
        Notification emailNotification = factory.createNotification("EMAIL");
        Notification smsNotification = factory.createNotification("SMS");
        Notification pushNotification = factory.createNotification("PUSH");

        emailNotification.send("Hello via Email with Factory!");
        smsNotification.send("Hello via SMS with Factory!");
        pushNotification.send("Hello via Push Notification with Factory!");
    }   
}
