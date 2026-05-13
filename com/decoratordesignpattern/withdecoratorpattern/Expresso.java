package com.decoratordesignpattern.withdecoratorpattern;

// Espresso.java — the base coffee, no add-ons
class Espresso implements Coffee {

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}