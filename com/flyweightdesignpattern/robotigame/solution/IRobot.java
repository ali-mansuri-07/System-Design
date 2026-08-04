package com.flyweightdesignpattern.robotigame.solution;

// The Flyweight interface
// Notice: display() takes x,y as PARAMETERS — not stored inside
// This is how extrinsic state is handled — passed in, never kept

public interface IRobot {
    void display(int x, int y); // x,y = extrinsic — unique per call
}