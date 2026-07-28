package com.interviewQuestions.cricbuzz.scoreupdater;

import com.interviewQuestions.cricbuzz.inning.BallDetails;
import com.interviewQuestions.cricbuzz.inning.BallType;
import com.interviewQuestions.cricbuzz.inning.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void updateScore(BallDetails ballDetails) {
        if (ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL) {
            ballDetails.bowledBy.bowlingScoreCard.totalOversCount += 1;
        }
        if (ballDetails.ballType == BallType.NOBALL) {
            ballDetails.bowledBy.bowlingScoreCard.noBallCount += 1;
        }
        if (ballDetails.ballType == BallType.WIDEBALL) {
            ballDetails.bowledBy.bowlingScoreCard.wideBallCount += 1;
        }
        if (ballDetails.wicket != null) {
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken += 1;
        }
        if (RunType.ONE == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 1;
        } else if (RunType.TWO == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 4;
        } else if (RunType.SIX == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 6;
        }
    }

}
