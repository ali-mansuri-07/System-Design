package com.interviewQuestions.tictactoe;

public class Player {
    String name;
    PlayingPieceType playingPieceType;
    public Player(String name, PlayingPieceType playingPieceType) {
        this.name = name;
        this.playingPieceType = playingPieceType;
    }
    public String getName() {
        return name;
    }
    public PlayingPieceType getPlayingPieceType() {
        return playingPieceType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPlayingPieceType(PlayingPieceType playingPieceType) {
        this.playingPieceType = playingPieceType;
    }
}
