package com.prototypedesignpattern.withprototypedesignpattern;
import java.util.Arrays;

// Main class to demonstrate the Prototype Design Pattern using prototypes
public class Main {
    public static void main(String[] args) {

        // Create the PROTOTYPE — the base template
        StudentProfile prototype = new StudentProfile(
                "Template",
                "IIT Kharagpur",
                "Computer Science",
                "Kharagpur",
                2,
                Arrays.asList("OS", "DBMS", "Networks", "Algorithms")
        );

        // ── Clone 1 — Rahul ─────────────────────────────
        StudentProfile rahul = prototype.clone();
        rahul.setName("Rahul");
        // Only name changed — everything else copied from prototype

        // ── Clone 2 — Priya ─────────────────────────────
        StudentProfile priya = prototype.clone();
        priya.setName("Priya");
        priya.addSubject("Machine Learning"); // Priya has an extra subject

        // ── Clone 3 — Arjun ─────────────────────────────
        StudentProfile arjun = prototype.clone();
        arjun.setName("Arjun");
        arjun.setYearOfStudy(3); // Arjun is in year 3

        // Print all
        System.out.println(rahul);
        System.out.println(priya);
        System.out.println(arjun);

        // ── Deep copy verification ───────────────────────
        System.out.println("\n--- Deep copy check ---");
        System.out.println("Priya's subjects == Rahul's subjects? "
                + (priya.subjects == rahul.subjects)); // false — different lists!

        // Priya has ML but Rahul doesn't — proof of independence
        System.out.println("Rahul's subjects: " + rahul.subjects);
        System.out.println("Priya's subjects: " + priya.subjects);
    }
}