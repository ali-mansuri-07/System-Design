package com.facadedesignpattern.withoutfacadedesignpattern;

import com.facadedesignpattern.AuditLogger;
import com.facadedesignpattern.DatabaseConnection;
import com.facadedesignpattern.EmailService;
import com.facadedesignpattern.NotificationService;
import com.facadedesignpattern.PayrollSystem;

// BAD — EmployeeController doing everything itself
// Client knows DB, email, payroll, audit, notifications
public class EmployeeControllerWithoutFacade {
    private DatabaseConnection    db           = new DatabaseConnection();
    private EmailService          emailService = new EmailService();
    private PayrollSystem         payroll      = new PayrollSystem();
    private AuditLogger           auditLogger  = new AuditLogger();
    private NotificationService   notification = new NotificationService();

    public void addEmployee(String name, String department,
                            String email, double salary) {
        // Must manually orchestrate ALL of this:
        db.openConnection();
        db.saveEmployee(name, department, salary);
        db.closeConnection();

        payroll.registerEmployee(name, salary);

        emailService.sendWelcomeEmail(email, name);

        auditLogger.log("ADD_EMPLOYEE", "HR_ADMIN",
                        "Added: " + name + " to " + department);

        notification.sendHRNotification("New hire: " + name);
        notification.sendSlackAlert("hr-updates",
                                    name + " joined " + department);

        // If ANY of these subsystems change, this method breaks
        // Cannot reuse this logic — copy-paste in every controller
    }
}