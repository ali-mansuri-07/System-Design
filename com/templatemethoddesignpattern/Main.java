package com.templatemethoddesignpattern;

public class Main {

    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();
        System.out.println("Tea");
        tea.prepareRecipe();
        System.out.println();
        System.out.println("Coffee");
        coffee.prepareRecipe();
    }
}