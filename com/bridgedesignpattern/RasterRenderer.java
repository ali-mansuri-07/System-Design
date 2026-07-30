package com.bridgedesignpattern;

class RasterRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for circle of radius " + radius);
    }

    public void renderSquare(float side) {
        System.out.println("Drawing pixels for square of side " + side);
    }
}