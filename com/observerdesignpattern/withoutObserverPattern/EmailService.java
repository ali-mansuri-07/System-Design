package com.observerdesignpattern.withoutObserverPattern;

// EmailObserver.java
class EmailService {
    private String emailId;

    EmailService(String emailId) {
        this.emailId = emailId;
    }

    void sendEmail(String item) {
        System.out.println("Email sent to " + emailId
                + " → Your order for [" + item + "] is confirmed!");
    }
}