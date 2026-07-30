package com.bridgedesignpattern;

class Circle extends Shape {
    private float radius;

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    public void draw() {
        renderer.renderCircle(radius); // delegate to implementor
    }

    public void resize(float factor) {
        radius *= factor;
    }
}