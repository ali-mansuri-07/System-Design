package com.nullobjectpattern.withnullobjectpattern;

// A "do-nothing" stand-in that implements the SAME interface
class NullEmployee implements Employee {

    @Override
    public String getName() {
        return "No Manager";   // safe default value
    }

    @Override
    public Employee getManager() {
        return this;   // returns itself — chains stay safe forever
    }

    @Override
    public void showDetails() {
        // does nothing — safe no-op
        System.out.println("This employee has no manager.");
    }
}