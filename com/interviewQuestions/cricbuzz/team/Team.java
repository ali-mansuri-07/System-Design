package com.interviewQuestions.cricbuzz.team;

import java.util.List;
import java.util.Queue;

import com.interviewQuestions.cricbuzz.team.player.PlayerBattingController;
import com.interviewQuestions.cricbuzz.team.player.PlayerBowlingController;
import com.interviewQuestions.cricbuzz.team.player.PlayerDetails;

public class Team {
    public String teamName;
    public Queue<PlayerDetails> players11;
    public List<PlayerDetails> playersBench;
    public PlayerBattingController playerBattingController;
    public PlayerBowlingController playerBowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<PlayerDetails> players11, List<PlayerDetails> playersBench,
            List<PlayerDetails> bowlers) {
        this.teamName = teamName;
        this.players11 = players11;
        this.playersBench = playersBench;
        this.playerBattingController = new PlayerBattingController(players11);
        this.playerBowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsman() throws Exception {
        playerBattingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler) {
        playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails getStriker() {
        return playerBattingController.getStriker();
    }

    public PlayerDetails getNonStriker() {
        return playerBattingController.getNonStriker();
    }

    public void setStriker(PlayerDetails striker) {
        playerBattingController.setStriker(striker);
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        playerBattingController.setNonStriker(nonStriker);
    }

    public PlayerDetails getCurrentBowler() {
        return playerBowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        System.out.println("Batting Score Card for team: " + teamName);
        for (PlayerDetails player : players11) {
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        System.out.println("Bowling Score Card for team: " + teamName);
        for (PlayerDetails player : players11) {
            player.printBowlingScoreCard();
        }
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for (PlayerDetails player : players11) {
            totalRuns += player.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }
}
