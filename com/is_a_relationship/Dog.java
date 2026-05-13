package com.is_a_relationship;

// Dog IS-A Animal
public class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);   // calls Animal's constructor
        this.breed = breed;
    }

    void bark() {
        System.out.println("Woof!");
    }
}