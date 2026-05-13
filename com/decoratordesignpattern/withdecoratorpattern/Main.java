package com.decoratordesignpattern.withdecoratorpattern;

// Main class to demonstrate the Decorator Design Pattern
public class Main {
    public static void main(String[] args) {

        // Plain Espresso — no decorators
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());
        // Espresso -> Rs.100.0

        System.out.println("----------------------------------");

        // Espresso + Milk
        Coffee coffeeWithMilk = new MilkDecorator(new Espresso());
        System.out.println(coffeeWithMilk.getDescription() + " -> Rs." + coffeeWithMilk.getCost());
        // Espresso, Milk -> Rs.130.0

        System.out.println("----------------------------------");
        // Espresso + Milk + Sugar
        Coffee coffeeWithMilkSugar = new SugarDecorator(
                                         new MilkDecorator(
                                             new Espresso()));
        System.out.println(coffeeWithMilkSugar.getDescription() + " -> Rs." + coffeeWithMilkSugar.getCost());
        // Espresso, Milk, Sugar -> Rs.140.0

        System.out.println("----------------------------------");

        // Espresso + Milk + Sugar + Caramel — fully loaded!
        Coffee fullyCloaded = new CaramelDecorator(
                                  new SugarDecorator(
                                      new MilkDecorator(
                                          new Espresso())));
        System.out.println(fullyCloaded.getDescription() + " -> Rs." + fullyCloaded.getCost());
        // Espresso, Milk, Sugar, Caramel -> Rs.190.0

        System.out.println("----------------------------------");

        // Double Caramel — stack same decorator twice!
        Coffee doubleCaramel = new CaramelDecorator(
                                   new CaramelDecorator(
                                       new Espresso()));
        System.out.println(doubleCaramel.getDescription() + " -> Rs." + doubleCaramel.getCost());
        // Espresso, Caramel, Caramel -> Rs.200.0
    }
}