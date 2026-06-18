package com.statedesignpattern.withstatedesignpattern;

class GreenState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("🟢 GREEN  — GO! You may cross.");
    }

    @Override
    public void change(TrafficLight light) {
        System.out.println("Green → Yellow");
        light.setState(new YellowState()); // Green goes to Yellow next
    }
}