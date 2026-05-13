package com.factorydesignpattern.factorymethod;

class SMSSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new SMSNotification(); // SMSSender creates SMS
    }
}
