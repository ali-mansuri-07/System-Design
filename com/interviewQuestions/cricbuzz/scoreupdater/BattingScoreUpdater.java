package com.interviewQuestions.cricbuzz.scoreupdater;

import com.interviewQuestions.cricbuzz.inning.BallDetails;
import com.interviewQuestions.cricbuzz.inning.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void updateScore(BallDetails ballDetails) {
        int run = 0;
        if (RunType.ONE == ballDetails.runType) {
            run = 1;
        } else if (RunType.TWO == ballDetails.runType) {
            run = 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            run = 4;
            ballDetails.playedBy.battingScoreCard.totalFours++;
        } else if (RunType.SIX == ballDetails.runType) {
            run = 6;
            ballDetails.playedBy.battingScoreCard.totalSix++;
        }
        // Update the batting score based on the ball details
        ballDetails.playedBy.battingScoreCard.totalRuns += run;
        ballDetails.playedBy.battingScoreCard.totalBallsPlayed += 1;
        // wicket details update
        if (ballDetails.wicket != null) {
            ballDetails.playedBy.battingScoreCard.wicketDetails = ballDetails.wicket;
        }

    }

}
