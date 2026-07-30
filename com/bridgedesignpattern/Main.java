package com.bridgedesignpattern;

public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle(new VectorRenderer(), 5);
        circle1.draw(); 

        Shape circle2 = new Circle(new RasterRenderer(), 5);
        circle2.draw();

        Shape square1 = new Square(new VectorRenderer(), 10);
        square1.draw();

        square1.resize(2);
        square1.draw();
    }
}