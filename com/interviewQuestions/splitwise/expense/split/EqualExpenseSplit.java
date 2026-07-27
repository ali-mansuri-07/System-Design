package com.interviewQuestions.splitwise.expense.split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList,
            double totalAmount) {

        double share = totalAmount / splitList.size();

        for (Split split : splitList) {
            split.setAmountOwe(share);
        }
    }
}