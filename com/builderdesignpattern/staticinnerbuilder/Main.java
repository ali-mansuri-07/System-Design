package com.builderdesignpattern.staticinnerbuilder;

// Main class to demonstrate the Builder Design Pattern with a Static Inner Builder
public class Main {
    public static void main(String[] args) {

        // Student with all fields
        Student s1 = new Student.Builder("Rahul", 21)
                .setEmail("rahul@gmail.com")
                .setPhone("+91-9876543210")
                .setAddress("Kolkata, West Bengal")
                .setCourse("Computer Science")
                .build();

        System.out.println(s1);

        System.out.println();

        // Student with only mandatory fields — optional ones are N/A
        Student s2 = new Student.Builder("Priya", 19)
                .setCourse("Data Science")
                .build();

        System.out.println(s2);

        System.out.println();

        // Validation — missing mandatory field throws exception
        try {
            Student s3 = new Student.Builder("", 21).build();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Error: Name is mandatory!
        }
        
    }
}