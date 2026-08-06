package com.mediatordesignpattern;

public class Main{
    public static void main(String[] args) {
        // Create an auction mediator for a painting auction
        AuctionMediator mediator = new AuctionHouse("Painting", 100.0);

        // Create bidders and register them with the mediator
        IColleague bidder1 = new Bidder("Bidder 1", mediator);
        IColleague bidder2 = new Bidder("Bidder 2", mediator);
        IColleague bidder3 = new Bidder("Bidder 3", mediator);

        mediator.registerBidder(bidder1);
        mediator.registerBidder(bidder2);
        mediator.registerBidder(bidder3);

        bidder1.placeBid(100);
        bidder2.placeBid(150);
        bidder3.placeBid(200);

        mediator.closeAuction();
    }
}

