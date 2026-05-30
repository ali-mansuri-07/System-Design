package com.chainofresponsibilitydesignpattern.withchainofresponsibility;

public class CEO extends LeaveApprover {
    @Override
    public void approveLeave(int leaveDays) {
        if (leaveDays > 14) {
            System.out.println("CEO approved the leave");
        } else if (nextApprover != null) {
            nextApprover.approveLeave(leaveDays);
        }
    }
}
