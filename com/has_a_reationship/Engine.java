package com.has_a_reationship;

class Engine {
    int horsepower;

    Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    void ignite() {
        System.out.println("Engine started!");
    }
}

class GPS {
    void navigate(String destination) {
        System.out.println("Navigating to " + destination);
    }
}

// Car HAS-A Engine, HAS-A GPS
class Car {
    String model;
    Engine engine;   // composition
    GPS gps;         // composition

    Car(String model) {
        this.model = model;
        this.engine = new Engine(200);
        this.gps = new GPS();
    }

    void start() {
        engine.ignite();   // delegates to Engine
    }
}