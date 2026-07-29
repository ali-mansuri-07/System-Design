package com.facadedesignpattern;

// Subsystem 5 — sends push notifications and Slack alerts
public class NotificationService {
    public void sendHRNotification(String message) {
        System.out.println("[HR NOTIFICATION] " + message);
    }

    public void sendSlackAlert(String channel, String message) {
        System.out.println("[SLACK → #" + channel + "] " + message);
    }

    public void sendPushNotification(String userId, String message) {
        System.out.println("[PUSH → " + userId + "] " + message);
    }
}