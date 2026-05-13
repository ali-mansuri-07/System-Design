package com.observerdesignpattern;

// SMSObserver.java
class SMSObserver implements Observer {
    private String phoneNumber;

    SMSObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String item) {
        System.out.println("SMS sent to " + phoneNumber
                + " → Order placed for [" + item + "]");
    }
}