package com.templatemethoddesignpattern;

public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Brewing Coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
