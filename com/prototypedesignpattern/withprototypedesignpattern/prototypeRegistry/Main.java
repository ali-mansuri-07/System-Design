package com.prototypedesignpattern.withprototypedesignpattern.prototypeRegistry;

import java.util.Arrays;

// Main class to demonstrate the Prototype Design Pattern using prototype registry
public class Main {
    public static void main(String[] args) {

        // Set up registry with pre-built templates
        PrototypeRegistry registry = new PrototypeRegistry();

        registry.register("CS-Y2",
            new StudentProfile("Template", "IIT Kharagpur",
                "Computer Science", "Kharagpur", 2,
                Arrays.asList("OS", "DBMS", "Networks")));

        registry.register("AI-Y3",
            new StudentProfile("Template", "IIT Bombay",
                "Artificial Intelligence", "Mumbai", 3,
                Arrays.asList("ML", "Deep Learning", "NLP")));

        // Create students from registry — just clone and set name
        StudentProfile rahul = registry.get("CS-Y2");
        rahul.setName("Rahul");

        StudentProfile priya = registry.get("AI-Y3");
        priya.setName("Priya");

        StudentProfile arjun = registry.get("CS-Y2"); // another CS student
        arjun.setName("Arjun");

        System.out.println(rahul);
        System.out.println(priya);
        System.out.println(arjun);
    }
}