package com.facadedesignpattern.withfacadedesignpattern;

// EmployeeController.java — Client using Facade
// Notice: knows NOTHING about DB, email, payroll, audit, notifications
public class EmployeeController {

    // Only dependency — the Facade
    private EmployeeDAOFacade employeeFacade = new EmployeeDAOFacade();

    public void onboardEmployee() {
        // One clean call — Facade does all the work
        employeeFacade.addEmployee(
            "EMP001", "Rahul Kumar",
            "Engineering", "rahul@company.com",
            120000
        );
    }

    public void offboardEmployee() {
        employeeFacade.removeEmployee(
            "EMP001", "Rahul Kumar",
            "rahul@company.com"
        );
    }

    public void giveSalaryRevision() {
        employeeFacade.updateSalary(
            "EMP001", "Rahul Kumar",
            "rahul@company.com",
            150000
        );
    }
}