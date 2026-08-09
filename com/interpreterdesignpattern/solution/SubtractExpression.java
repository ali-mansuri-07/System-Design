package com.interpreterdesignpattern.solution;

// SubtractExpression.java — NonTerminal
public class SubtractExpression implements MathExpression {
    private MathExpression left;
    private MathExpression right;

    public SubtractExpression(MathExpression left, MathExpression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " - " + right + ")";
    }
}
