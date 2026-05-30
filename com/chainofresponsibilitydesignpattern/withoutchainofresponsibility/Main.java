package com.chainofresponsibilitydesignpattern.withoutchainofresponsibility;

public class Main {
    public static void main(String[] args) {
        TeamLead teamLead = new TeamLead();
        Manager manager = new Manager();
        Director director = new Director();
        CEO ceo = new CEO();
        int leavedays = 10;
        if (leavedays <= 1) {
            teamLead.approve();
        } else if (leavedays <= 3) {
            manager.approve();
        } else if (leavedays <= 7) {
            director.approve();
        } else {
            ceo.approve();
        }
    }
}
