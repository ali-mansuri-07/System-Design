package com.chainofresponsibilitydesignpattern.withchainofresponsibility;

public class Director extends LeaveApprover {
    @Override
    public void approveLeave(int leaveDays) {
        if (leaveDays <= 14) {
            System.out.println("Director approved the leave");
        } else if (nextApprover != null) {
            nextApprover.approveLeave(leaveDays);
        }
    }
}
