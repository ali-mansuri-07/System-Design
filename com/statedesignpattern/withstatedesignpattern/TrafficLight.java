package com.statedesignpattern.withstatedesignpattern;

public class TrafficLight {
    private TrafficLightState currentState;

    // Starts with Red light
    public TrafficLight() {
        currentState = new RedState();
    }

    public void action() {
        currentState.action();
    }

    public void change() {
        currentState.change(this);
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public String getCurrentState() {
        return currentState.getClass().getSimpleName();
    }

}
