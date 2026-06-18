package com.statedesignpattern.withstatedesignpattern;

public interface TrafficLightState {
    void action();
    void change(TrafficLight trafficLight);
}
