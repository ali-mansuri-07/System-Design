package com.decoratordesignpattern.withdecoratorpattern;

// This is the Decorator class that implements the same interface as the base component (Coffee)
public class CoffeeDecorator implements Coffee {

    // It has a reference to a Coffee object, which it decorates
    private Coffee coffee;

    // The constructor takes a Coffee object to decorate
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    // The decorator delegates the calls to the wrapped Coffee object
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    // The cost is also delegated to the wrapped Coffee object
    @Override
    public double getCost() {
        return coffee.getCost();
    }
    
}
