package com.flyweightdesignpattern.robotigame.solution;

// Client — uses the factory, passes extrinsic state (x,y) each time

public class RoboticGameSimulation {
    public static void main(String[] args) {
        System.out.println("====== Flyweight Design Pattern ======");

        // Request 1: HUMANOID — creates NEW object, cached
        IRobot humanoidRobot1 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1, 2);
        // Creating NEW HUMANOID
        // Displaying HUMANOID at 1, 2

        // Request 2: HUMANOID again — returns SAME cached object
        IRobot humanoidRobot2 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10, 30);
        // Returning cached HUMANOID
        // Displaying HUMANOID at 10, 30

        // humanoidRobot1 == humanoidRobot2 → TRUE (same object!)

        // Request 3: ROBOTIC_DOG — creates NEW object, cached
        IRobot roboDog1 = RoboticFactory.createRobot("ROBOTIC_DOG");
        roboDog1.display(2, 9);
        // Creating NEW ROBOTIC_DOG
        // Displaying ROBOTIC_DOG at 2, 9

        // Request 4: ROBOTIC_DOG again — same cached object
        IRobot roboDog2 = RoboticFactory.createRobot("ROBOTIC_DOG");
        roboDog2.display(11, 19);
        // Returning cached ROBOTIC_DOG
        // Displaying ROBOTIC_DOG at 11, 19

        // roboDog1 == roboDog2 → TRUE (same object!)

        // Only 2 actual robot objects created — regardless of how many times you call
        System.out.println("Total robots created: " + RoboticFactory.getTotalRobots());
        // Total robots created: 2

        // Verify they are the SAME object
        System.out.println("humanoidRobot1 == humanoidRobot2 : " +
                (humanoidRobot1 == humanoidRobot2)); // true
        System.out.println("roboDog1 == roboDog2 : " +
                (roboDog1 == roboDog2)); // true
    }
}



