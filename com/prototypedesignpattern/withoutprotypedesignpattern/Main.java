package com.prototypedesignpattern.withoutprotypedesignpattern;

// Main class to demonstrate the Prototype Design Pattern without using prototypes
public class Main {
    public static void main(String[] args) {
        // Creating a StudentProfile object with all parameters
        // Student1
        StudentProfile student = new StudentProfile();
        student.name = "Alice";
        student.age = 20;
        student.course = "B.Tech";
        student.branch = "Computer Science";   
        student.year = 3;
        System.out.println(student.name + ", " + student.age + ", " + student.course + ", " + student.branch + ", " + student.year);

        // Student2
        StudentProfile student2 = new StudentProfile();
        student2.name = "Bob";
        student2.age = 22;  
        student2.course = "B.Tech";
        student2.branch = "Electrical";
        student2.year = 4;
        System.out.println(student2.name + ", " + student2.age + ", " + student2.course + ", " + student2.branch + ", " + student2.year);

    }
}
