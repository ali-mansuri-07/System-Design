package com.interviewQuestions.splitwise.expense.split;

import java.util.List;

import com.interviewQuestions.splitwise.expense.ExpenseSplitType;
import com.interviewQuestions.splitwise.user.User;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType expenseSplitType;
    List<Split> splitDetails;

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.expenseSplitType = expenseSplitType;
        this.splitDetails = splitDetails;
    }
}
