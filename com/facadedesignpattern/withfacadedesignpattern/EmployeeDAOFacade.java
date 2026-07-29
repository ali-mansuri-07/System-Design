package com.facadedesignpattern.withfacadedesignpattern;

import com.facadedesignpattern.AuditLogger;
import com.facadedesignpattern.DatabaseConnection;
import com.facadedesignpattern.EmailService;
import com.facadedesignpattern.NotificationService;
import com.facadedesignpattern.PayrollSystem;

// EmployeeDAOFacade.java
// THE FACADE — one clean interface hiding all complexity
public class EmployeeDAOFacade {

    // Facade OWNS the subsystems — client never touches them
    private DatabaseConnection  db;
    private EmailService        emailService;
    private PayrollSystem       payroll;
    private AuditLogger         auditLogger;
    private NotificationService notification;

    public EmployeeDAOFacade() {
        // Facade sets up everything internally
        this.db           = new DatabaseConnection();
        this.emailService = new EmailService();
        this.payroll      = new PayrollSystem();
        this.auditLogger  = new AuditLogger();
        this.notification = new NotificationService();
    }

    // ── Simple method 1 — Add Employee ────────────────────────
    // Client calls ONE method.
    // Facade internally coordinates all 5 subsystems.
    public void addEmployee(String employeeId, String name,
                            String department, String email,
                            double salary) {
        System.out.println("\n--- Adding Employee: " + name + " ---");

        // Step 1: Save to DB
        db.openConnection();
        db.saveEmployee(name, department, salary);
        db.closeConnection();

        // Step 2: Register in payroll
        payroll.registerEmployee(employeeId, salary);

        // Step 3: Send welcome email
        emailService.sendWelcomeEmail(email, name);

        // Step 4: Audit log
        auditLogger.log("ADD_EMPLOYEE", "HR_ADMIN",
                        "Added " + name + " to " + department);

        // Step 5: Notify HR and Slack
        notification.sendHRNotification("New hire: " + name +
                                        " in " + department);
        notification.sendSlackAlert("hr-updates",
                                    name + " has joined " + department);

        System.out.println("--- Employee " + name + " added successfully ---");
    }

    // ── Simple method 2 — Remove Employee ─────────────────────
    public void removeEmployee(String employeeId, String name,
                               String email) {
        System.out.println("\n--- Removing Employee: " + name + " ---");

        db.openConnection();
        db.deleteEmployee(employeeId);
        db.closeConnection();

        payroll.removeFromPayroll(employeeId);

        emailService.sendTerminationEmail(email, name);

        auditLogger.log("REMOVE_EMPLOYEE", "HR_ADMIN",
                        "Removed employee: " + name +
                        " (id=" + employeeId + ")");

        notification.sendHRNotification("Employee exit: " + name);
        notification.sendSlackAlert("hr-updates",
                                    name + " has left the company.");

        System.out.println("--- Employee " + name +
                           " removed successfully ---");
    }

    // ── Simple method 3 — Update Salary ───────────────────────
    public void updateSalary(String employeeId, String name,
                             String email, double newSalary) {
        System.out.println("\n--- Updating Salary for: " + name + " ---");

        db.openConnection();
        db.updateSalary(employeeId, newSalary);
        db.closeConnection();

        payroll.updateSalaryInPayroll(employeeId, newSalary);

        emailService.sendSalaryUpdateEmail(email, newSalary);

        auditLogger.log("UPDATE_SALARY", "HR_ADMIN",
                        "Updated salary for " + name +
                        " to Rs." + newSalary);

        notification.sendPushNotification(employeeId,
                        "Your CTC has been updated to Rs." + newSalary);

        System.out.println("--- Salary updated for " + name +
                           " successfully ---");
    }
}