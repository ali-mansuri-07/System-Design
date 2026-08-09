package com.interpreterdesignpattern.solution;

public class MathMain {
    public static void main(String[] args) {

        System.out.println("===== Math Expression Interpreter =====\n");

        // ── Expression 1: 5 + 3 ───────────────────────────────
        MathExpression expr1 = new AddExpression(
            new NumberLiteral(5),
            new NumberLiteral(3)
        );
        System.out.println(expr1 + " = " + expr1.interpret());
        // (5 + 3) = 8

        // ── Expression 2: 5 + 3 * 2 ──────────────────────────
        // Represent correct precedence: 5 + (3 * 2)
        MathExpression expr2 = new AddExpression(
            new NumberLiteral(5),
            new MultiplyExpression(
                new NumberLiteral(3),
                new NumberLiteral(2)
            )
        );
        System.out.println(expr2 + " = " + expr2.interpret());
        // (5 + (3 * 2)) = 11

        // ── Expression 3: (5 + 3) * 2 ────────────────────────
        // Parens change the tree structure
        MathExpression expr3 = new MultiplyExpression(
            new AddExpression(
                new NumberLiteral(5),
                new NumberLiteral(3)
            ),
            new NumberLiteral(2)
        );
        System.out.println(expr3 + " = " + expr3.interpret());
        // ((5 + 3) * 2) = 16

        // ── Expression 4: (10 - 4) / (1 + 2) ────────────────
        MathExpression expr4 = new DivideExpression(
            new SubtractExpression(
                new NumberLiteral(10),
                new NumberLiteral(4)
            ),
            new AddExpression(
                new NumberLiteral(1),
                new NumberLiteral(2)
            )
        );
        System.out.println(expr4 + " = " + expr4.interpret());
        // ((10 - 4) / (1 + 2)) = 2

        // ── Expression 5: deeply nested ───────────────────────
        // ((2 + 3) * (4 - 1)) + (10 / 2)
        MathExpression expr5 = new AddExpression(
            new MultiplyExpression(
                new AddExpression(new NumberLiteral(2), new NumberLiteral(3)),
                new SubtractExpression(new NumberLiteral(4), new NumberLiteral(1))
            ),
            new DivideExpression(
                new NumberLiteral(10),
                new NumberLiteral(2)
            )
        );
        System.out.println(expr5 + " = " + expr5.interpret());
        // (((2 + 3) * (4 - 1)) + (10 / 2)) = 20

        // ── Division by zero handling ─────────────────────────
        System.out.println("\n--- Error handling ---");
        try {
            MathExpression divByZero = new DivideExpression(
                new NumberLiteral(10),
                new NumberLiteral(0)
            );
            divByZero.interpret();
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
            // Caught: Division by zero
        }
    }
}