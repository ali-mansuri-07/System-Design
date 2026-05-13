package com.association;

// Demonstrating Association where Teacher and Student are associated with each other
public class Main {
    public static void main(String[] args) {
        // Main
        Teacher teacher = new Teacher("Mr. Sharma");
        Student student = new Student("Rahul");

        teacher.teach(student);
        // Mr. Sharma is teaching Rahul
        // Rahul is learning
    }
}
