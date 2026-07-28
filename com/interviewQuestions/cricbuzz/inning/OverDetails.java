package com.interviewQuestions.cricbuzz.inning;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.cricbuzz.team.Team;
import com.interviewQuestions.cricbuzz.team.player.PlayerDetails;

public class OverDetails {
    public int overNumber;
    public List<BallDetails> balls;
    public int extraBowlscount;
    public PlayerDetails bowledBy;

    public OverDetails(int overNumber, PlayerDetails bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 0;
        while (ballCount < 6) {
            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            balls.add(ball);
            if (ball.ballType == BallType.NORMAL) {
                ballCount++;
                if (ball.wicket != null) {
                    battingTeam.chooseNextBatsman();
                }
                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }
            } else {
                extraBowlscount++;
            }
        }
        return false;
    }
}
