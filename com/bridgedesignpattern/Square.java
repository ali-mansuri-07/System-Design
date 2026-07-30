package com.bridgedesignpattern;

class Square extends Shape {
    private float side;

    public Square(Renderer renderer, float side) {
        super(renderer);
        this.side = side;
    }

    public void draw() {
        renderer.renderSquare(side);
    }

    public void resize(float factor) {
        side *= factor;
    }
}
