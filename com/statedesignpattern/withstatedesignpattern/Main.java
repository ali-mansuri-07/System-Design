package com.statedesignpattern.withstatedesignpattern;

public class Main {
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();

        System.out.println("\n--- Normal cycle ---");

        for (int i = 0; i < 6; i++) {
            light.action(); // do current state's action
            light.change(); // transition to next state
        }

        // 🔴 RED — STOP! Do not cross.
        // Red → Green
        // 🟢 GREEN — GO! You may cross.
        // Green → Yellow
        // 🟡 YELLOW — SLOW DOWN! Prepare to stop.
        // Yellow → Red
        // 🔴 RED — STOP! Do not cross.
        // Red → Green
        // 🟢 GREEN — GO! You may cross.
        // Green → Yellow

        System.out.println("\n--- Trigger emergency flashing mode ---");

        light.setState(new FlashingState()); // inject new state directly
        light.action();
        light.change(); // goes back to Red
        light.action();

        // ⚡ FLASHING — Caution! Proceed carefully.
        // Flashing → Red (resuming normal cycle)
        // 🔴 RED — STOP! Do not cross.
    }
}
