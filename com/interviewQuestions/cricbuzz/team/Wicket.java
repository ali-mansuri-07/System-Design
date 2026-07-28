package com.interviewQuestions.cricbuzz.team;

import com.interviewQuestions.cricbuzz.inning.BallDetails;
import com.interviewQuestions.cricbuzz.inning.OverDetails;
import com.interviewQuestions.cricbuzz.team.player.PlayerDetails;

public class Wicket {
    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetails;
    public BallDetails ballDetails;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetails, BallDetails ballDetails) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetails = overDetails;
        this.ballDetails = ballDetails;
    }

}
