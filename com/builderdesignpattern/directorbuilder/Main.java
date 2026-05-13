package com.builderdesignpattern.directorbuilder;

// Main class to demonstrate the Builder Design Pattern with a Director
public class Main {
    public static void main(String[] args) {

        // Build a Veg Burger
        Director director = new Director(new VegBuilder());
        Burger vegBurger = director.construct();
        System.out.println(vegBurger);
        // Burger { bread=Whole Wheat, patty=Aloo Tikki,
        //          cheese=No Cheese, sauce=Mint Chutney }

        System.out.println();

        // Swap builder — same Director, different result!
        director = new Director(new NonVegBurgerBuilder());
        Burger nonVegBurger = director.construct();
        System.out.println(nonVegBurger);
        // Burger { bread=Sesame Bun, patty=Chicken Patty,
        //          cheese=Double Cheese, sauce=BBQ Sauce }
    }
}