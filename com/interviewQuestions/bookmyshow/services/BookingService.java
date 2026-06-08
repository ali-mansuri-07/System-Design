package com.interviewQuestions.bookmyshow.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.interviewQuestions.bookmyshow.entities.Booking;
import com.interviewQuestions.bookmyshow.entities.Payment;
import com.interviewQuestions.bookmyshow.entities.Show;
import com.interviewQuestions.bookmyshow.entities.User;
import com.interviewQuestions.bookmyshow.enums.PaymentStatus;

public class BookingService {
    private final Map<UUID, Booking> bookings = new HashMap<>();

    public Booking book(User user, Show show, List<Integer> seatIds) {
        if (!show.lockSeats(seatIds)) {
            throw new RuntimeException("Seat unavailable");
        }
        // Process payment
        Payment payment = new Payment(100, PaymentStatus.SUCCESS);

        // Create booking and update seat status
        if (payment.getPaymentStatus() == PaymentStatus.SUCCESS) {
            show.confirmSeats(seatIds);
            Booking booking = new Booking(user, show, seatIds, payment);
            bookings.put(booking.getBookingId(), booking);
            return booking;
        } else {
            show.releaseSeats(seatIds);
            throw new RuntimeException("Payment failed");
        }
    }

    public Booking getBooking(UUID bookingId) {
        return bookings.get(bookingId);
    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookings.values().stream()
                .filter(booking -> booking.getUser().getUserId().equals(userId))
                .toList();
    }
}
