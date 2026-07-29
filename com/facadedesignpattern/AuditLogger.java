package com.facadedesignpattern;

// Subsystem 4 — logs every operation for compliance
public class AuditLogger {
    private String logFile = "/var/log/company/audit.log";

    public void log(String action, String performedBy, String details) {
        String timestamp = java.time.LocalDateTime.now().toString();
        System.out.println("[AUDIT LOG → " + logFile + "] " +
                timestamp + " | action=" + action +
                " | by=" + performedBy +
                " | details=" + details);
    }
}