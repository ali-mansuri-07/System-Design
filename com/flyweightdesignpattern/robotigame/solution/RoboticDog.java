package com.flyweightdesignpattern.robotigame.solution;

// Another ConcreteFlyweight — same pattern as HumanoidRobot

public class RoboticDog implements IRobot {

    // Intrinsic state — stored once, shared by ALL robotic dogs
    private final String type; // always "ROBOTIC_DOG"
    private final Sprites body; // one Sprites shared by all 5 lakh dogs

    RoboticDog(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at " + x + ", " + y);
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }
}