package com.visitordesignpattern.solution;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // THE KEY — passes 'this' (Rectangle) to visitor
    // Java now knows both types: Rectangle + whichever Visitor was passed
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this); // double dispatch
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return "Rectangle(w=" + width + ", h=" + height + ")";
    }

}
