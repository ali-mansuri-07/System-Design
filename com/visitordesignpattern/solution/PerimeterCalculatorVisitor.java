package com.visitordesignpattern.solution;

// Operation 2: Calculate perimeter — zero changes to shape classes
public class PerimeterCalculatorVisitor implements ShapeVisitor {
    private double perimeter;

    @Override
    public void visit(Circle circle) {
        perimeter = 2 * Math.PI * circle.getRadius();
    }

    @Override
    public void visit(Rectangle rectangle) {
        perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
    }

    @Override
    public void visit(Triangle triangle) {
        perimeter = triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
    }

    public double getPerimeter() {
        return perimeter;
    }
    
}
