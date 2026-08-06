package com.mediatordesignpattern;

// Colleague interface
public class Bidder implements IColleague {
    protected AuctionMediator mediator;
    protected String name;

    public Bidder(String name, AuctionMediator mediator) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void placeBid(double amount) {
        System.out.println("\n===> [Placing Bid] " + name + " is attempting to bid $" + amount);
        mediator.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(double bidAmount) {
        System.out.println("[+] Bidder " + name + " has received a new bid notification of: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}