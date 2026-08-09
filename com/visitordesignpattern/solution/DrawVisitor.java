package com.visitordesignpattern.solution;

// Operation 3: Draw each shape differently
public class DrawVisitor implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing a " + circle.getColor() + " circle with radius " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing a " + rectangle.getColor() + " rectangle with width " + rectangle.getWidth() + " and height " + rectangle.getHeight());
    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("Drawing a " + triangle.getColor() + " triangle with sides " + triangle.getSideA() + ", " + triangle.getSideB() + ", and " + triangle.getSideC());
    }
    
}
