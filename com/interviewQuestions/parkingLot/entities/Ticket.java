package com.interviewQuestions.parkingLot.entities;

import java.time.LocalDateTime;

import com.interviewQuestions.parkingLot.spots.ParkingSpot;

public class Ticket {
    public String id;
    public Vehicle vehicle;
    public ParkingSpot spot;
    public LocalDateTime entryTime;

    private Ticket(TicketBuilder builder) {
        this.id = builder.id;
        this.vehicle = builder.vehicle;
        this.spot = builder.spot;
        this.entryTime = builder.entryTime != null ? builder.entryTime : LocalDateTime.now();
    }

    public static class TicketBuilder {
        private String id;
        private Vehicle vehicle;
        private ParkingSpot spot;
        private LocalDateTime entryTime;

        public TicketBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TicketBuilder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public TicketBuilder spot(ParkingSpot spot) {
            this.spot = spot;
            return this;
        }

        public TicketBuilder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    public static TicketBuilder builder() {
        return new TicketBuilder();
    }
}