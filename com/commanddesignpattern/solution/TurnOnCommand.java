package com.commanddesignpattern.solution;

public class TurnOnCommand implements ICommand {
    private AirConditioner airConditioner;
    private boolean preState;

    public TurnOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        preState = airConditioner.isOn();
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        if(!preState) {
            airConditioner.turnOff();
        }
    }
    
}
