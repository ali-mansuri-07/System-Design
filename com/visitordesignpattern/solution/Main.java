package com.visitordesignpattern.solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("======= Visitor Design Pattern =======\n");

        // Build shape collection — elements
        List<Shape> shapes = Arrays.asList(
                new Circle(5.0, "RED"),
                new Circle(3.0, "BLUE"),
                new Rectangle(4.0, 6.0, "RED"),
                new Rectangle(2.0, 8.0, "GREEN"),
                new Triangle(3.0, 4.0, 5.0, "BLUE"),
                new Triangle(6.0, 8.0, 10.0, "RED"));

        // ── Visitor 1: Area calculation ───────────────────────
        System.out.println("--- Area Calculation ---");
        AreaCalculatorVisitor areaVisitor = new AreaCalculatorVisitor();
        for (Shape shape : shapes) {
            shape.accept(areaVisitor); // each shape calls visitor.visit(this)
        }
        areaVisitor.printTotal();

        // ── Visitor 2: Perimeter calculation ──────────────────
        System.out.println("\n--- Perimeter Calculation ---");
        PerimeterCalculatorVisitor perimeterVisitor = new PerimeterCalculatorVisitor();
        for (Shape shape : shapes) {
            shape.accept(perimeterVisitor);
        }

        // ── Visitor 3: Draw ───────────────────────────────────
        System.out.println("\n--- Drawing Shapes ---");
        DrawVisitor drawVisitor = new DrawVisitor();
        for (Shape shape : shapes) {
            shape.accept(drawVisitor);
        }

        // ── Visitor 4: Export to XML ──────────────────────────
        System.out.println("\n--- Exporting to XML ---");
        ExportVisitor exportVisitor = new ExportVisitor();
        for (Shape shape : shapes) {
            shape.accept(exportVisitor);
        }
        System.out.println("\nGenerated XML:\n" + exportVisitor.getXml());

    }
}


