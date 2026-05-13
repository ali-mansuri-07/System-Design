package com.observerdesignpattern;

// WhatsAppObserver.java — added later, OrderService never touched!
class WhatsAppObserver implements Observer {
    private String phoneNumber;

    WhatsAppObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String item) {
        System.out.println("WhatsApp sent to " + phoneNumber
                + " → Hey! Your [" + item + "] order is on its way 🚀");
    }
}