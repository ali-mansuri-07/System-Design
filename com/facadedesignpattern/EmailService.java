package com.facadedesignpattern;

// Subsystem 2 — handles all email configuration and sending
public class EmailService {
    private String smtpHost  = "smtp.company.com";
    private int    smtpPort  = 587;
    private String senderEmail = "hr@company.com";

    public void configure() {
        System.out.println("Configuring SMTP: " + smtpHost + ":" + smtpPort);
    }

    public void sendWelcomeEmail(String toEmail, String employeeName) {
        configure();
        System.out.println("Sending welcome email to " + toEmail +
                           " → Subject: Welcome, " + employeeName + "!");
    }

    public void sendTerminationEmail(String toEmail, String employeeName) {
        configure();
        System.out.println("Sending termination email to " + toEmail +
                           " → Subject: Regarding " + employeeName);
    }

    public void sendSalaryUpdateEmail(String toEmail, double newSalary) {
        configure();
        System.out.println("Sending salary update email to " + toEmail +
                           " → New CTC: Rs." + newSalary);
    }
}
