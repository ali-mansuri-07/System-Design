package com.builderdesignpattern.withoutbuilderdesignpattern;

// Main class to demonstrate the Builder Design Pattern without using a Builder
public class Main {
    public static void main(String[] args) {
        // Creating a User object with all parameters
        User user = new User("John Doe", 30, "john.doe@example.com", "123-456-7890", "123 Main St");
        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
        System.out.println("Email: " + user.email);
        System.out.println("Phone: " + user.phone);
        System.out.println("Address: " + user.address);
    }
}
