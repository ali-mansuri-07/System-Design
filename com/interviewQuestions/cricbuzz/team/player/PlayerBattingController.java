package com.interviewQuestions.cricbuzz.team.player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<PlayerDetails> yetToBat;
    PlayerDetails striker;
    PlayerDetails nonStriker;

    public PlayerBattingController(Queue<PlayerDetails> playing11) {
        this.yetToBat = new LinkedList<>(playing11);
    }

    public void getNextPlayer() {
        if (yetToBat.isEmpty()) {
            throw new RuntimeException("All players are out");
        }
        if (striker == null) {
            striker = yetToBat.poll();
        } else if (nonStriker == null) {
            nonStriker = yetToBat.poll();
        }
    }

    public void setStriker(PlayerDetails striker) {
        this.striker = striker;
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        this.nonStriker = nonStriker;
    }

    public PlayerDetails getStriker() {
        return striker;
    }

    public PlayerDetails getNonStriker() {
        return nonStriker;
    }

}
