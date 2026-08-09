package com.interpreterdesignpattern.solution;

// AddExpression.java — NonTerminal
public class AddExpression implements MathExpression {
    private MathExpression left;
    private MathExpression right;

    public AddExpression(MathExpression left, MathExpression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
