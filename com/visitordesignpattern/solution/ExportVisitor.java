package com.visitordesignpattern.solution;

// Operation 4 — NEW operation added WITHOUT touching shape classes
// This is OCP at its best — shapes are closed for modification
public class ExportVisitor implements ShapeVisitor {

    private StringBuilder xml = new StringBuilder();

    public ExportVisitor() {
        xml.append("<?xml version=\"1.0\"?>\n<shapes>\n");
    }

    @Override
    public void visit(Circle circle) {
        xml.append("  <circle ")
                .append("radius=\"").append(circle.getRadius()).append("\" ")
                .append("color=\"").append(circle.getColor()).append("\"/>\n");
        System.out.println("Exported Circle to XML");
    }

    @Override
    public void visit(Rectangle rectangle) {
        xml.append("  <rectangle ")
                .append("width=\"").append(rectangle.getWidth()).append("\" ")
                .append("height=\"").append(rectangle.getHeight()).append("\" ")
                .append("color=\"").append(rectangle.getColor()).append("\"/>\n");
        System.out.println("Exported Rectangle to XML");
    }

    @Override
    public void visit(Triangle triangle) {
        xml.append("  <triangle ")
                .append("a=\"").append(triangle.getSideA()).append("\" ")
                .append("b=\"").append(triangle.getSideB()).append("\" ")
                .append("c=\"").append(triangle.getSideC()).append("\" ")
                .append("color=\"").append(triangle.getColor()).append("\"/>\n");
        System.out.println("Exported Triangle to XML");
    }

    public String getXml() {
        return xml.append("</shapes>").toString();
    }
}