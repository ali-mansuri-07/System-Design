package com.chainofresponsibilitydesignpattern.withchainofresponsibility;

public class TeamLead extends LeaveApprover {
    @Override
    public void approveLeave(int leaveDays) {
        if (leaveDays <= 3) {
            System.out.println("Team Lead approved the leave");
        } else if (nextApprover != null) {
            nextApprover.approveLeave(leaveDays);
        }
    }
}
