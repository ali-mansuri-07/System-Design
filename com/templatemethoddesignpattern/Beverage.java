package com.templatemethoddesignpattern;

public abstract class Beverage {

    // Template Method
    public final void prepareRecipe() {
        // Common steps for all beverages
        boilWater();

        brew();

        pourInCup();

        addCondiments();
    }

    private void boilWater() {

        System.out.println("Boiling Water");
    }

    private void pourInCup() {

        System.out.println("Pouring into Cup");
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void brew();
    
    protected abstract void addCondiments();
}
