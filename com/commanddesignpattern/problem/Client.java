package com.commanddesignpattern.problem;

public class Client {
    public static void main(String[] args) {
        // Device: Air Conditioner Commands
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.setTemperature(25);
        airConditioner.turnOff();

        // Device: Bulb Commands
        Bulb bulb = new Bulb();
        bulb.turnOn();
        bulb.turnOff();
    }
}
