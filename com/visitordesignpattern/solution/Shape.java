package com.visitordesignpattern.solution;

public interface Shape {
    void accept(ShapeVisitor visitor);
    String getName();
}
