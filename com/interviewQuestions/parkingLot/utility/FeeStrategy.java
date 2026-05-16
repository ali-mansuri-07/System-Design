package com.interviewQuestions.parkingLot.utility;

import com.interviewQuestions.parkingLot.entities.Ticket;

public interface FeeStrategy {
    double calculate(Ticket ticket);
}