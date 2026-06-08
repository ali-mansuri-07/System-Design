package com.interviewQuestions.bookmyshow.entities;

import java.util.List;

import com.interviewQuestions.bookmyshow.enums.City;

public class Theatre {
    String theatreName;
    City city;
    List<Screen> screens;

    public Theatre(String theatreName, City city, List<Screen> screens) {
        this.theatreName = theatreName;
        this.city = city;
        this.screens = screens;
    }

    public City getCity() {
        return city;
    }
    
    public List<Screen> getScreens() {
        return screens;
    }

    public String getTheatreName() {
        return theatreName;
    }
}
