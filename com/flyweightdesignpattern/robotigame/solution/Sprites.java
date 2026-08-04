package com.flyweightdesignpattern.robotigame.solution;

// This is the EXPENSIVE object — a 2D bitmap image
// Without Flyweight: 10,00,000 of these created
// With Flyweight: exactly 2 created (one per robot type)

public class Sprites {
    // Large 2D bitmap in memory
    // In real games this could be megabytes per object
}