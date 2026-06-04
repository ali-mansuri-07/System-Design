package com.interviewQuestions.snakeladdergame;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 5, 5);
        Dice dice = new Dice(1, 1, 6);
        Game game = new Game(board, dice);
        game.startGame();
    }
}