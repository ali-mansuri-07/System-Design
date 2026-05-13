package com.is_a_relationship;

// Demonstrating IS-A relationship where Dog IS-A Animal
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.eat();   // Buddy is eating
        dog.sleep(); // Buddy is sleeping
        dog.bark();  // Woof!
    }
}
