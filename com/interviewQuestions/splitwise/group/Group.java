package com.interviewQuestions.splitwise.group;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.splitwise.expense.ExpenseController;
import com.interviewQuestions.splitwise.expense.ExpenseSplitType;
import com.interviewQuestions.splitwise.expense.split.Expense;
import com.interviewQuestions.splitwise.expense.split.Split;
import com.interviewQuestions.splitwise.user.User;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> groupExpenses;
    ExpenseController expenseController;
    public Group(){
        groupMembers = new ArrayList<>();
        groupExpenses = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User user){
        groupMembers.add(user);
    }

    public void setGroupId(String groupId){
        this.groupId = groupId;
    }

    public String getGroupId(){
        return this.groupId;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
            List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        groupExpenses.add(expense);
        return expense;
    }
}
