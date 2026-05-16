package com.interviewQuestions.parkingLot.gates;

import com.interviewQuestions.parkingLot.entities.ParkingLot;
import com.interviewQuestions.parkingLot.entities.Ticket;

public class ExitGate {

    public String gateId;
    public ParkingLot parkingLot;

    public ExitGate(String gateId) {
        this.gateId = gateId;
        this.parkingLot = ParkingLot.getInstance();
    }

    public double unparkVehicle(Ticket ticket) {
        ticket.spot.release();

        return parkingLot.feeStrategy.calculate(ticket);
    }
}