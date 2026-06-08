package com.interviewQuestions.bookmyshow.entities;

import com.interviewQuestions.bookmyshow.enums.SeatCategory;

public class Seat {
    int seatId;
    SeatCategory category;

    public Seat(int seatId, SeatCategory category) {
        this.seatId = seatId;
        this.category = category;
    }

    public int getSeatId() {
        return seatId;
    }
}
