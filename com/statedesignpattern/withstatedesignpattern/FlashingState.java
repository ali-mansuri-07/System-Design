package com.statedesignpattern.withstatedesignpattern;

// FlashingState.java — brand new state, zero existing code modified!
class FlashingState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("⚡ FLASHING — Caution! Proceed carefully.");
    }

    @Override
    public void change(TrafficLight light) {
        System.out.println("Flashing → Red (resuming normal cycle)");
        light.setState(new RedState());
    }
}