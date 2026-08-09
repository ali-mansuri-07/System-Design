package com.interpreterdesignpattern.solution;

// MultiplyExpression.java — NonTerminal
public class MultiplyExpression implements MathExpression {
    private MathExpression left;
    private MathExpression right;

    public MultiplyExpression(MathExpression left, MathExpression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}