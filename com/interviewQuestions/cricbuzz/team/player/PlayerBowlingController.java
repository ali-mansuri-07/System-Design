package com.interviewQuestions.cricbuzz.team.player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<PlayerDetails> bowlersList;
    Map<PlayerDetails, Integer> bowlerVsOverCount;
    PlayerDetails currentBowler;

    public PlayerBowlingController(List<PlayerDetails> bowlers) {
        setBowlersList(bowlers);
    }

    private void setBowlersList(List<PlayerDetails> bowlersList) {
        this.bowlersList = new LinkedList<>();
        bowlerVsOverCount = new HashMap<>();
        for (PlayerDetails bowler : bowlersList) {
            this.bowlersList.addLast(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        PlayerDetails nextBowler = bowlersList.pollFirst();
        // If the next bowler has already bowled the maximum overs, then we will not add
        // him back to the list and will select the next bowler from the list.
        if (bowlerVsOverCount.get(nextBowler) + 1 == maxOverCountPerBowler) {
            currentBowler = nextBowler;
        } else {
            currentBowler = nextBowler;
            bowlersList.addLast(nextBowler);
            bowlerVsOverCount.put(nextBowler, bowlerVsOverCount.get(nextBowler) + 1);
        }
    }

    public PlayerDetails getCurrentBowler() {
        return currentBowler;
    }
}
