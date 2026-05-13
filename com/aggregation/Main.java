package com.aggregation;

// Demonstrating Aggregation where Department HAS-A Professors
public class Main {
    public static void main(String[] args) {
        // Main
        Professor p1 = new Professor("Dr. Roy");
        Professor p2 = new Professor("Dr. Das");
        Department dept = new Department("Computer Science");
        dept.addProfessor(p1);
        dept.addProfessor(p2);
        // If dept is deleted, p1 and p2 still exist!
        // They can join another department
        System.out.println(dept.name + " has professors:");
        for (Professor p : dept.professors) {
            System.out.println("- " + p.name);
        }
    }
}
