package com.interviewQuestions.snakeladdergame;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("Player1", 0);
        Player player2 = new Player("Player2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            // check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println(
                    "Player turn : " + playerTurn.getId() + " current position is: " + playerTurn.getCurrentPosition());

            // roll the dice
            int diceNumbers = dice.rollDice();

            // get the new position
            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);

            System.out.println("Player turn : " + playerTurn.getId() + " new Position is: " + playerNewPosition);
            // check for winning condition
            if (playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("\n===> The Winner is : " + winner.getId());
    }

    private Player findPlayerTurn() {
        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null) {
            return cell.jump.getEnd();
        }
        return playerNewPosition;
    }
}
