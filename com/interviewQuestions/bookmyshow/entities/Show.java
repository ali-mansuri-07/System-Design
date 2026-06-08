package com.interviewQuestions.bookmyshow.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.interviewQuestions.bookmyshow.enums.SeatStatus;

public class Show {
    Movie movie;
    LocalDate showDate;
    LocalTime showTime;
    private final Map<Integer, SeatStatus> seatStatusMap = new HashMap<>();
    private final Map<Integer, ReentrantLock> seatLocks = new HashMap<>();

    public Show(Movie movie, Screen screen, LocalDate showDate, LocalTime showTime) {
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;

        for (Seat seat : screen.getSeats()) {
            seatStatusMap.put(seat.getSeatId(), SeatStatus.AVAILABLE);
            seatLocks.put(seat.getSeatId(), new ReentrantLock());
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public boolean lockSeats(List<Integer> seatIds) {
        List<Integer> sorted = new ArrayList<>(seatIds);

        // sorting i am doing to avoid deadlock scenario
        Collections.sort(sorted);

        List<ReentrantLock> acquiredLocks = new ArrayList<>();

        try {
            // Step 1 - Acquire locks for all seats
            for (Integer seatId : sorted) {
                ReentrantLock lock = seatLocks.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }

            // Step 2 - Check if all seats are available
            for (Integer seatId : sorted) {
                if (seatStatusMap.get(seatId) != SeatStatus.AVAILABLE) {
                    return false; // If any seat is not available, return false
                }
            }

            // Step 3 - Mark seats as LOCKED
            for (Integer seatId : sorted) {
                seatStatusMap.put(seatId, SeatStatus.LOCKED);
            }

            return true; // Successfully locked all seats
        } finally {
            // Step 4 - Release all locks
            for (ReentrantLock lock : acquiredLocks) {
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds) {
        for (Integer seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.BOOKED);
        }
    }

    public void releaseSeats(List<Integer> seatIds) {
        for (Integer seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }
}
