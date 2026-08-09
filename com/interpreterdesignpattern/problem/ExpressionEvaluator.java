package com.interpreterdesignpattern.problem;

class ExpressionEvaluator {
    public boolean evaluate(String expression, int value) {
        if (expression.equals("isEven")) {
            return value % 2 == 0;
        } else if (expression.equals("isPositive")) {
            return value > 0;
        } else if (expression.equals("isEven AND isPositive")) {
            return value % 2 == 0 && value > 0;
        } else if (expression.equals("isEven OR isPositive")) {
            return value % 2 == 0 || value > 0;
        }
        // Every new expression = edit this class!
        // Combinations explode exponentially!
        return false;
    }
}
