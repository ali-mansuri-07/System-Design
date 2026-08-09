package com.visitordesignpattern.solution;

// Operation 1: Calculate area for each shape type
// No shape class was modified to add this operation
public class AreaCalculatorVisitor implements ShapeVisitor {
    private double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        totalArea += area;
        System.out.println("Calculating area for " + circle.getName() + ": " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        totalArea += area;
        System.out.println("Calculating area for " + rectangle.getName() + ": " + area);
    }

    @Override
    public void visit(Triangle triangle) {
        // Heron's formula
        double a = triangle.getSideA();
        double b = triangle.getSideB();
        double c = triangle.getSideC();
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.printf("Area of %-30s = %.2f%n",
                triangle.getName(), area);
        totalArea += area;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void printTotal() {
        System.out.printf("Total area of all shapes = %.2f%n", totalArea);
    }

}
