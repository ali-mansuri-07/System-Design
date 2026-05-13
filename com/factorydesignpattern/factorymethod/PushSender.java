package com.factorydesignpattern.factorymethod;

class PushSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new PushNotification();   // PushSender creates Push
    }
}