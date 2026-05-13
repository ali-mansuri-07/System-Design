package com.abstractfactorypattern;

// Main class to demonstrate the Abstract Factory Pattern
public class Main {
    public static void main(String[] args) {

        AbstractUiFactory factory;

        // Switch theme here
        factory = new LightThemeFactory();
        // factory = new DarkThemeFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();

        factory = new DarkThemeFactory();
        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}