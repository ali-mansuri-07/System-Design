package com.interviewQuestions.bookmyshow.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interviewQuestions.bookmyshow.entities.Movie;
import com.interviewQuestions.bookmyshow.entities.Screen;
import com.interviewQuestions.bookmyshow.entities.Show;
import com.interviewQuestions.bookmyshow.entities.Theatre;
import com.interviewQuestions.bookmyshow.enums.City;

public class TheaterService {
    private final Map<City, List<Theatre>> cityTheaters = new HashMap<>();

    public void addTheatre(Theatre theatre) {
        cityTheaters.computeIfAbsent(theatre.getCity(), k -> new java.util.ArrayList<>()).add(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date) {
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatres = cityTheaters.getOrDefault(city, List.of());

        for (Theatre theatre : theatres) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShowsByDate(date)) {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public List<Theatre> getTheatres(City city, String movieName, LocalDate showDate) {
        List<Theatre> theatres = cityTheaters.getOrDefault(city, List.of());

        return theatres.stream()
                .filter(t -> t.getScreens().stream()
                        .anyMatch(s -> s.getShowsByDate(showDate).stream()
                                .anyMatch(show -> show.getMovie().equals(movieName))))
                .toList();
    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre) {
        List<Show> result = new ArrayList<>();

        for (Screen screen : theatre.getScreens()) {
            for (Show show : screen.getShowsByDate(date)) {
                if (show.getMovie().equals(movie)) {
                    result.add(show);
                }
            }
        }
        return result;
    }
}
