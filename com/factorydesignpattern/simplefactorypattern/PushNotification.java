package com.factorydesignpattern.simplefactorypattern;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push notification sent with message: " + message);
    }   
}
