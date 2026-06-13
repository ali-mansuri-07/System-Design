package com.nullobjectpattern.withhoutnullobjectpattern;

// BAD — caller must check for null EVERYWHERE
public class Main {
    public static void main(String[] args) {

        Employee ceo = new Employee("Mr. Sharma", null); // CEO has no manager!
        Employee dev = new Employee("Rahul", ceo);

        printManagerName(dev); // works fine
        printManagerName(ceo); // NullPointerException risk!
    }

    public static void printManagerName(Employee emp) {
        Employee manager = emp.getManager();

        // Must check null — easy to forget, crashes if forgotten
        if (manager != null) {
            System.out.println(emp.getName() + "'s manager is " + manager.getName());
        } else {
            System.out.println(emp.getName() + " has no manager");
        }
    }
}
