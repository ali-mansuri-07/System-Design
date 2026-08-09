package com.visitordesignpattern.solution;

public class Circle implements Shape {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // THE KEY — passes 'this' (Circle) to visitor
    // Java now knows both types: Circle + whichever Visitor was passed
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this); // double dispatch
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return "Circle(r=" + radius + ")";
    }
}