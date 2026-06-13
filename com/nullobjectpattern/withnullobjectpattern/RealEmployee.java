package com.nullobjectpattern.withnullobjectpattern;

// RealEmployee.java
class RealEmployee implements Employee {
    private String name;
    private Employee manager;

    RealEmployee(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Employee getManager() {
        // Never returns null — returns NullEmployee instead if no manager
        return manager;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + " | Manager: " + manager.getName());
    }
}