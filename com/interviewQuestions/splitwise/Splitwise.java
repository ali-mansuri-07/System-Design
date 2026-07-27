package com.interviewQuestions.splitwise;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.interviewQuestions.splitwise.expense.ExpenseSplitType;
import com.interviewQuestions.splitwise.expense.split.Split;
import com.interviewQuestions.splitwise.group.Group;
import com.interviewQuestions.splitwise.group.GroupController;
import com.interviewQuestions.splitwise.user.User;
import com.interviewQuestions.splitwise.user.UserController;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void start() {
        setupUserAndGroup();

        // add users to group
        Group group = groupController.getGroup("G1");
        group.addMember(userController.getUserById("U1"));
        group.addMember(userController.getUserById("U2"));
        group.addMember(userController.getUserById("U3"));

        // create an expense
        List<Split> splitDetails = List.of(
                new Split(userController.getUserById("U1"), 0),
                new Split(userController.getUserById("U2"), 0),
                new Split(userController.getUserById("U3"), 0));

        group.createExpense("E1", "Dinner", 90, splitDetails, ExpenseSplitType.EQUAL,
                userController.getUserById("U1"));

        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }

        List<Split> splitDetails2 = List.of(
                new Split(userController.getUserById("U1"), 40),
                new Split(userController.getUserById("U2"), 60),
                new Split(userController.getUserById("U3"), 100));

        group.createExpense("E2", "Moview", 200, splitDetails2, ExpenseSplitType.UNEQUAL,
                userController.getUserById("U2"));
        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    private void setupUserAndGroup() {
        addUsersToSplitwise();
        // create a group
        User user1 = userController.getUserById("U1");
        groupController.createNewGroup("G1", "Group 1", user1);

    }

    private void addUsersToSplitwise() {
        User user1 = new User("U1", "User 1");
        User user2 = new User("U2", "User 2");
        User user3 = new User("U3", "User 3");
        User user4 = new User("U4", "User 4");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);
    }

    public void simplifyBalances(Map<User, Double> netBalance) {

        Queue<Map.Entry<User, Double>> creditors = new LinkedList<>();
        Queue<Map.Entry<User, Double>> debtors = new LinkedList<>();

        for (Map.Entry<User, Double> entry : netBalance.entrySet()) {

            if (entry.getValue() > 0) {
                creditors.offer(entry);
            } else if (entry.getValue() < 0) {
                debtors.offer(entry);
            }
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {

            Map.Entry<User, Double> creditor = creditors.poll();
            Map.Entry<User, Double> debtor = debtors.poll();

            double receive = creditor.getValue();
            double pay = -debtor.getValue();

            double settled = Math.min(receive, pay);

            System.out.println(
                    debtor.getKey().getUserName()
                            + " pays "
                            + creditor.getKey().getUserName()
                            + " : ₹"
                            + settled);

            receive -= settled;
            pay -= settled;

            if (receive > 0) {
                creditor.setValue(receive);
                creditors.offer(creditor);
            }

            if (pay > 0) {
                debtor.setValue(-pay);
                debtors.offer(debtor);
            }
        }
    }
}
