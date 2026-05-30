package com.chainofresponsibilitydesignpattern.withchainofresponsibility;

public class Manager extends LeaveApprover {
    @Override
    public void approveLeave(int leaveDays) {
        if (leaveDays <= 7) {
            System.out.println("Manager approved the leave");
        } else if (nextApprover != null) {
            nextApprover.approveLeave(leaveDays);
        }
    }

}
