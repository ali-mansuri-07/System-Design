package com.statedesignpattern.withstatedesignpattern;

class RedState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("🔴 RED   — STOP! Do not cross.");
    }

    @Override
    public void change(TrafficLight light) {
        System.out.println("Red → Green");
        light.setState(new GreenState()); // Red goes to Green next
    }
}