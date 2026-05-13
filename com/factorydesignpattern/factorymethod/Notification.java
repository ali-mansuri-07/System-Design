package com.factorydesignpattern.factorymethod;

// Notification interface - common contract for all notifications
public interface Notification {
    void send(String message);
}