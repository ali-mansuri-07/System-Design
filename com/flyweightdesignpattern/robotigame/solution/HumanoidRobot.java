package com.flyweightdesignpattern.robotigame.solution;

// ConcreteFlyweight — stores ONLY intrinsic (shared) state
// All fields are FINAL — because this object is shared, it must be immutable

public class HumanoidRobot implements IRobot {

    // ── Intrinsic state — shared, never changes ────────────
    private final String type; // always "HUMANOID"
    private final Sprites body; // one heavy Sprites object — shared by ALL humanoids

    HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    // Extrinsic state (x,y) received at runtime — NOT stored
    @Override
    public void display(int x, int y) {
        // uses shared body/type + unique x,y passed by caller
        System.out.println("Displaying " + type + " at " + x + ", " + y);
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }
}