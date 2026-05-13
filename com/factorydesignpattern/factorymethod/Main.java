package com.factorydesignpattern.factorymethod;

// Main class to demonstrate the Factory Method Design Pattern
// Step 3 — Main
public class Main {
    public static void main(String[] args) {

        // Pick the sender — it knows what to create internally
        NotificationSender sender;

        sender = new EmailSender();
        sender.sendNotification("Your order is confirmed!");
        // Email sent: Your order is confirmed!

        sender = new SMSSender();
        sender.sendNotification("OTP: 482910");
        // SMS sent: OTP: 482910

        sender = new PushSender();
        sender.sendNotification("Flash sale starts now!");
        // Push notification sent: Flash sale starts now!
    }
}