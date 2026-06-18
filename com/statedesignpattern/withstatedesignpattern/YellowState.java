package com.statedesignpattern.withstatedesignpattern;

class YellowState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("🟡 YELLOW — SLOW DOWN! Prepare to stop.");
    }

    @Override
    public void change(TrafficLight light) {
        System.out.println("Yellow → Red");
        light.setState(new RedState()); // Yellow goes back to Red
    }
}