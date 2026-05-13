package com.has_a_reationship;

//Demostrating HAS-A relationship where Car HAS-A GPS
// Car HAS-A GPS
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry");
        car.start();
        car.gps.navigate("Central Park");
    }
}
