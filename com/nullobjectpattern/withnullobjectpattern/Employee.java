package com.nullobjectpattern.withnullobjectpattern;

// Employee.java
// Both real employees AND the "null" placeholder implement this
interface Employee {
    String getName();
    Employee getManager();
    void showDetails();
}