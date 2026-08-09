package com.visitordesignpattern.solution;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String color;

    public Triangle(double sideA, double sideB, double sideC, String color) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.color = color;
    }

    // THE KEY — passes 'this' (Triangle) to visitor
    // Java now knows both types: Triangle + whichever Visitor was passed
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this); // double dispatch
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return "Triangle(a=" + sideA + ", b=" + sideB + ", c=" + sideC + ")";
    }

}
