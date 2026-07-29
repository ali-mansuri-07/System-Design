package com.facadedesignpattern;

// Subsystem 3 — handles salary computation and payroll registration
public class PayrollSystem {
    private double taxRate = 0.30;
    private double pfRate = 0.12;

    public void registerEmployee(String employeeId, double salary) {
        double tax = salary * taxRate;
        double pf = salary * pfRate;
        double takeHome = salary - tax - pf;
        System.out.println("Payroll registered → id=" + employeeId +
                ", gross=Rs." + salary +
                ", tax=Rs." + tax +
                ", PF=Rs." + pf +
                ", takeHome=Rs." + takeHome);
    }

    public void removeFromPayroll(String employeeId) {
        System.out.println("Removing from payroll → id=" + employeeId);
    }

    public void updateSalaryInPayroll(String employeeId, double newSalary) {
        double tax = newSalary * taxRate;
        double takeHome = newSalary - tax - (newSalary * pfRate);
        System.out.println("Payroll updated → id=" + employeeId +
                ", newTakeHome=Rs." + takeHome);
    }
}
