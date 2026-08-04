package com.flyweightdesignpattern.robotigame.problem;

public class Demo {
    public static void main(String[] args) {
        int x = 0, y = 0;

        // Create 5 lakh Humanoid robots
        for (int i = 0; i < 500000; i++) {
            Sprites humanoidSprite = new Sprites(); // NEW Sprites every time!
            Robot humanoidRobotObject = new Robot(x + i, y + i,
                    "HUMANOID", humanoidSprite);

            System.out.println("Humanoid Robot created at: " + (x + i) + ", " + (y + i) + " with Sprites object: " + humanoidRobotObject.body);
        }

        // Create 5 lakh Robotic Dog robots
        for (int i = 0; i < 500000; i++) {
            Sprites roboticDogSprite = new Sprites(); // NEW Sprites every time!
            Robot roboticDogObject = new Robot(x + i, y + i,
                    "ROBOTIC_DOGS", roboticDogSprite);
            System.out.println("Robotic Dog Robot created at: " + (x + i) + ", " + (y + i) + " with Sprites object: " + roboticDogObject.body);
        }

        // Result: 10,00,000 Sprites objects in memory!
        // Sprites is a HEAVY bitmap image — this kills the JVM
    }
}