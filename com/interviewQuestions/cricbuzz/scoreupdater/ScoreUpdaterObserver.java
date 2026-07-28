package com.interviewQuestions.cricbuzz.scoreupdater;

import com.interviewQuestions.cricbuzz.inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void updateScore(BallDetails ballDetails);
    
}
