package com.statedesignpattern.withoutstatedesignpattern;

// BAD — one giant class with if-else for every action
// Adding a new state means editing every single method

class TrafficLight {
    private String state = "RED";

    public void change() {
        if (state.equals("RED")) {
            System.out.println("Red → switching to Green");
            state = "GREEN";
        } else if (state.equals("GREEN")) {
            System.out.println("Green → switching to Yellow");
            state = "YELLOW";
        } else if (state.equals("YELLOW")) {
            System.out.println("Yellow → switching to Red");
            state = "RED";
        }
    }

    public void action() {
        if (state.equals("RED")) {
            System.out.println("STOP! Do not cross.");
        } else if (state.equals("GREEN")) {
            System.out.println("GO! You may cross.");
        } else if (state.equals("YELLOW")) {
            System.out.println("SLOW DOWN! Prepare to stop.");
        }
        // Adding FLASHING state = editing BOTH methods here + everywhere else
    }
}