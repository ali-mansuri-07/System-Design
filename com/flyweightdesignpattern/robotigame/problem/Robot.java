package com.flyweightdesignpattern.robotigame.problem;

// holds BOTH intrinsic and extrinsic data together
public class Robot {
    int coordinateX; // extrinsic — unique per robot
    int coordinateY; // extrinsic — unique per robot
    String type; // intrinsic — same for all humanoids
    Sprites body; // intrinsic — same for all humanoids — but duplicated!

    Robot(int coordinateX, int coordinateY, String type, Sprites body) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.type = type;
        this.body = body; // heavy object — 10 lakh copies wasted!
    }
}