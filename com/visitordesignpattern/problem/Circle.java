package com.visitordesignpattern.problem;

// BAD — adding new operations means modifying every class
// Imagine you have 3 shape types and want to add Area + Perimeter + Draw + Export

class Circle {
    double radius;

    // Adding new operation = edit this class
    double area()      { return Math.PI * radius * radius; }
    double perimeter() { return 2 * Math.PI * radius; }
    void   draw()      { System.out.println("Drawing circle"); }
    void   export()    { System.out.println("Exporting circle to XML"); }
    // Every new operation = modify ALL shape classes — violates OCP!
}

class Rectangle {
    double width, height;
    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }
    void   draw()      { System.out.println("Drawing rectangle"); }
    void   export()    { System.out.println("Exporting rectangle to XML"); }
    // Same explosion here...
}
