package com.nullobjectpattern.withnullobjectpattern;

public class Main {
    public static void main(String[] args) {

        // CEO has NO manager — instead of null, use NullEmployee
        Employee ceo = new RealEmployee("Mr. Sharma", new NullEmployee());

        // Rahul reports to the CEO
        Employee rahul = new RealEmployee("Rahul", ceo);

        // No null checks needed ANYWHERE!
        printManagerName(rahul);
        // Rahul's manager is Mr. Sharma

        printManagerName(ceo);
        // Mr. Sharma's manager is No Manager  ← safe, no crash!

        System.out.println();

        // showDetails() also works safely on the chain
        rahul.showDetails();
        // Employee: Rahul | Manager: Mr. Sharma

        ceo.showDetails();
        // Employee: Mr. Sharma | Manager: No Manager

        System.out.println();

        // Even calling getManager() on a NullEmployee is safe
        Employee ceosManager = ceo.getManager();
        ceosManager.showDetails();
        // This employee has no manager.
    }

    // No null check required — works for both RealEmployee and NullEmployee!
    public static void printManagerName(Employee emp) {
        Employee manager = emp.getManager();
        System.out.println(emp.getName() + "'s manager is " + manager.getName());
    }
}