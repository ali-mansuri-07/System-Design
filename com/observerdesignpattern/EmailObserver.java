package com.observerdesignpattern;

// EmailObserver.java
class EmailObserver implements Observer {
    private String emailId;

    EmailObserver(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update(String item) {
        System.out.println("Email sent to " + emailId
                + " → Your order for [" + item + "] is confirmed!");
    }
}