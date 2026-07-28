package com.interviewQuestions.cricbuzz;

public class OneDayMatch implements MatchType {

    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxOverCountBowlers() {
        return 10;
    }

}
