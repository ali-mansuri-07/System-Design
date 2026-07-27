package com.interviewQuestions.splitwise.expense.split;

import com.interviewQuestions.splitwise.expense.ExpenseSplitType;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType expenseSplitType) {
        if (expenseSplitType == ExpenseSplitType.EQUAL) {
            return new EqualExpenseSplit();
        } else if (expenseSplitType == ExpenseSplitType.UNEQUAL) {
            return new UnequalExpenseSplit();
        } else if (expenseSplitType == ExpenseSplitType.PERCENTAGE) {
            return new PercentageExpenseSplit();
        }
        return null;
    }
}
