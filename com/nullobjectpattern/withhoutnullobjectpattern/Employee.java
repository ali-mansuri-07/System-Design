package com.nullobjectpattern.withhoutnullobjectpattern;

// Employee.java
class Employee {
    private String name;
    private Employee manager; // can be null for CEO!

    Employee(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }
}
