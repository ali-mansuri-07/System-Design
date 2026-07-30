package com.bridgedesignpattern;

abstract class Shape {
    protected Renderer renderer; // <-- the "bridge"

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();

    public abstract void resize(float factor);
}
