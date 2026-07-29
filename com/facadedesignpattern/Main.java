package com.facadedesignpattern;

import com.facadedesignpattern.withfacadedesignpattern.EmployeeController;

public class Main {
    public static void main(String[] args) {

        EmployeeController controller = new EmployeeController();

        // Onboard new employee
        controller.onboardEmployee();

        // Give salary hike
        controller.giveSalaryRevision();

        // Offboard the employee
        controller.offboardEmployee();
    }
}