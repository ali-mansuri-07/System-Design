package com.interviewQuestions.parkingLot.parkingStrategy;

import com.interviewQuestions.parkingLot.entities.Ticket;
import com.interviewQuestions.parkingLot.utility.FeeStrategy;

public class HourlyFeeStrategy implements FeeStrategy {
    public double calculate(Ticket ticket) {
        return 100.0;
    }
}