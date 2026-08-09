package com.interpreterdesignpattern.solution;

// Leaf — just holds and returns a number
public class NumberLiteral implements MathExpression {
    private int number;

    public NumberLiteral(int number) { this.number = number; }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String toString() { return String.valueOf(number); }
}