package com.interviewQuestions.bookmyshow.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.bookmyshow.entities.Movie;
import com.interviewQuestions.bookmyshow.entities.Show;
import com.interviewQuestions.bookmyshow.entities.Theatre;
import com.interviewQuestions.bookmyshow.enums.City;
import com.interviewQuestions.bookmyshow.services.TheaterService;

public class TheatreController {
    private final TheaterService theaterService;

    public TheatreController() {
        this.theaterService = new TheaterService();
    }

    public void addTheatre(Theatre theatre) {
        theaterService.addTheatre(theatre);
    }

    public List<Movie> getMovies(City city, LocalDate date) {
        return new ArrayList<>(theaterService.getMovies(city, date));
    }

    public List<Theatre> getTheatres(City city, String movieName, LocalDate showDate) {
        return theaterService.getTheatres(city, movieName, showDate);
    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre) {
        return theaterService.getShows(movie, date, theatre);
    }
}
