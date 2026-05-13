package com.observerdesignpattern.withoutObserverPattern;

public class SMSService {
    private String phoneNumber;

    SMSService(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void sendSMS(String item) {
        System.out.println("SMS sent to " + phoneNumber
                + " → Order placed for [" + item + "]");
    }
}
