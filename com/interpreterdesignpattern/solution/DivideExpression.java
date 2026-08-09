package com.interpreterdesignpattern.solution;

// DivideExpression.java — NonTerminal
public class DivideExpression implements MathExpression {
    private MathExpression left;
    private MathExpression right;

    public DivideExpression(MathExpression left, MathExpression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int rightVal = right.interpret();
        if (rightVal == 0)
            throw new ArithmeticException("Division by zero");
        return left.interpret() / rightVal;
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}