package com.facadedesignpattern;

// Subsystem 1 — handles all DB connection boilerplate
public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection() {
        this.url = "jdbc:mysql://localhost:3306/company_db";
        this.username = "root";
        this.password = "secret";
    }

    public void openConnection() {
        System.out.println("Opening DB connection to: " + url);
        // In real code: DriverManager.getConnection(url, username, password)
    }

    public void closeConnection() {
        System.out.println("Closing DB connection");
    }

    public void saveEmployee(String name, String department, double salary) {
        System.out.println("Saving employee to DB → name=" + name +
                ", dept=" + department + ", salary=" + salary);
    }

    public void deleteEmployee(String employeeId) {
        System.out.println("Deleting employee from DB → id=" + employeeId);
    }

    public void updateSalary(String employeeId, double newSalary) {
        System.out.println("Updating salary in DB → id=" + employeeId +
                ", newSalary=" + newSalary);
    }
}