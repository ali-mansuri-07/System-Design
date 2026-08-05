package com.commanddesignpattern.problem;

public class AirConditioner {
    int temperature;
    boolean isOn;

    public void turnOn() {
        isOn = true;
        System.out.println("Air Conditioner is turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Air Conditioner is turned OFF");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Air Conditioner temperature set to " + temperature + " degrees");
    }
}
