package com.interviewQuestions.cricbuzz.inning;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.cricbuzz.MatchType;
import com.interviewQuestions.cricbuzz.team.Team;
import com.interviewQuestions.cricbuzz.team.player.PlayerDetails;

public class InningDetails {
    public Team battingTeam;
    public Team bowlingTeam;
    public MatchType matchType;
    List<OverDetails> overs;

    public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void startInning(int runsToWin) {
        // Logic to start the inning
        try {
            battingTeam.chooseNextBatsman();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber = 0; overNumber < noOfOvers; overNumber++) {
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());
            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if (won == true) {
                    System.out.println("Inning Ended. Batting Team Won");
                    break;
                }
            } catch (Exception e) {
                break;
            }

            // swap striker and non striker
            PlayerDetails temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }

    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }
}
