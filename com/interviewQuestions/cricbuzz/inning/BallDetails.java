package com.interviewQuestions.cricbuzz.inning;

import java.util.*;

import com.interviewQuestions.cricbuzz.scoreupdater.BattingScoreUpdater;
import com.interviewQuestions.cricbuzz.scoreupdater.BowlingScoreUpdater;
import com.interviewQuestions.cricbuzz.scoreupdater.ScoreUpdaterObserver;
import com.interviewQuestions.cricbuzz.team.Team;
import com.interviewQuestions.cricbuzz.team.Wicket;
import com.interviewQuestions.cricbuzz.team.WicketType;
import com.interviewQuestions.cricbuzz.team.player.PlayerDetails;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails bowledBy;
    public PlayerDetails playedBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails overDetails) {
        playedBy = battingTeam.getStriker();
        bowledBy = bowlingTeam.getCurrentBowler();
        ballType = getBallType();
        runType = getRunType();

        if (isWicketTaken()) {
            runType = RunType.ZERO;
            wicket = new Wicket(WicketType.BOWLED, bowledBy, overDetails, this);
            battingTeam.setStriker(null);
        } else {
            runType = getRunType();
            // swap striker and non-striker if run is odd
            if (runType == RunType.ONE || runType == RunType.THREE) {
                PlayerDetails temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

        // update player scorecard based on the ball details
        for (ScoreUpdaterObserver scoreUpdaterObserver : scoreUpdaterObserverList) {
            scoreUpdaterObserver.updateScore(this);
        }
    }

    private boolean isWicketTaken() {
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }

    public BallType getBallType() {
        double val = Math.random();
        if (val <= 0.2) {
            return BallType.NOBALL;
        } else if (val >= 0.3 && val <= 0.5) {
            return BallType.WIDEBALL;
        } else {
            return BallType.NORMAL;
        }
    }

    private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

}
