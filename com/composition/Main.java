package com.composition;

// Demonstrating Composition where House HAS-A Rooms
public class Main {
    public static void main(String[] args) {
        // Main
        House house = new House("12 Park Street, Kolkata");
        house.showRooms();
        // If house is garbage collected, all Room objects die with it.

    }
}
