package com.flyweightdesignpattern.robotigame.solution;

// Flyweight Factory — creates objects ONCE and caches them
// Every subsequent request for the same type returns the SAME object

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {

    // THE CACHE — key = robot type, value = the shared flyweight object
    // Only 2 entries ever: "HUMANOID" and "ROBOTIC_DOG"
    private static final Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {

        // Check cache first
        if (roboticObjectCache.containsKey(robotType)) {
            System.out.println("Returning cached " + robotType);
            return roboticObjectCache.get(robotType); // same object returned
        }

        // Not in cache — create ONCE and store
        if (robotType.equals("HUMANOID")) {
            Sprites humanoidSprite = new Sprites(); // created ONCE
            IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);
            roboticObjectCache.put(robotType, humanoidObject);
            System.out.println("Creating NEW " + robotType);
            return humanoidObject;

        } else if (robotType.equals("ROBOTIC_DOG")) {
            Sprites roboticDogSprite = new Sprites(); // created ONCE
            IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);
            roboticObjectCache.put(robotType, roboticDogObject);
            System.out.println("Creating NEW " + robotType);
            return roboticDogObject;
        }

        throw new IllegalArgumentException("Invalid robot type: " + robotType);
    }

    public static int getTotalRobots() {
        return roboticObjectCache.size(); // always 2 regardless of 10 lakh calls
    }
}