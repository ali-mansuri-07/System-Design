package com.commanddesignpattern.solution;

public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOn() {
        isOn = true;
        System.out.println("Air Conditioner is turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Air Conditioner is turned OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Air Conditioner temperature set to " + temperature + " degrees");
    }

    public int getTemperature() {
        return temperature;
    }
}
