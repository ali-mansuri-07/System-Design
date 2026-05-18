package com.interviewQuestions.tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initializeGame();
        String result = ticTacToeGame.startGame();
        System.out.println(result);
    }
}