package com.bridgedesignpattern;

class VectorRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius + " as vector lines");
    }

    public void renderSquare(float side) {
        System.out.println("Drawing a square of side " + side + " as vector lines");
    }
}