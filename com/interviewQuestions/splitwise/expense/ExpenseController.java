package com.interviewQuestions.splitwise.expense;

import java.util.List;

import com.interviewQuestions.splitwise.BalanceSheetController;
import com.interviewQuestions.splitwise.expense.split.Expense;
import com.interviewQuestions.splitwise.expense.split.ExpenseSplit;
import com.interviewQuestions.splitwise.expense.split.Split;
import com.interviewQuestions.splitwise.expense.split.SplitFactory;
import com.interviewQuestions.splitwise.user.User;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
            List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }

}
