package com.interviewQuestions.bookmyshow.controllers;

import java.util.List;
import java.util.UUID;

import com.interviewQuestions.bookmyshow.entities.Booking;
import com.interviewQuestions.bookmyshow.entities.Show;
import com.interviewQuestions.bookmyshow.entities.User;
import com.interviewQuestions.bookmyshow.services.BookingService;

public class BookingController {
    private final BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    public Booking createBooking(User user, Show show, List<Integer> seatIds) {
        return bookingService.book(user, show, seatIds);
    }

    public Booking getBooking(UUID bookingId) {
        return bookingService.getBooking(bookingId);
    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookingService.getBookingsByUser(userId);
    }
}
