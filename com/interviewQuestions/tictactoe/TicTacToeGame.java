package com.interviewQuestions.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    Player winner;

    public TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {
        players = new LinkedList<>();
        // Creating the board
        board = new Board(3);
        // Creating the players
        Player player1 = new Player("Player 1", new PlayingPieceType(PieceType.X));
        Player player2 = new Player("Player 2", new PlayingPieceType(PieceType.O));
        // Adding the players to the queue
        players.add(player1);
        players.add(player2);
    }

    @SuppressWarnings("resource")
    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            // Get the current player whose turn it is and ask them to make a move
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            // get the free cells on the board and ask the player to choose one
            List<int[]> freeCells = board.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }
            // Take the player's move and update the board
            System.out.println(currentPlayer.getName() + ", it's your turn. Please choose a cell (row, col):");
            Scanner scanner = new Scanner(System.in);
            String cell = scanner.nextLine();
            String[] cellCoordinates = cell.split(",");
            int row = Integer.parseInt(cellCoordinates[0]);
            int col = Integer.parseInt(cellCoordinates[1]);
            // Place the player's piece on the board
            boolean piecePlaceSuccessfully = board.updateBoard(row, col, currentPlayer.getPlayingPieceType());
            if (!piecePlaceSuccessfully) {
                // If the cell is already occupied, ask the player to choose another cell
                System.out.println("Cell is already occupied. Please choose another cell.");
                // Add the player back to the front of the queue so they can make another move
                players.addFirst(currentPlayer);
                continue;
            }
            //if the move is valid, add the player back to the end of the queue for the next turn
            players.addLast(currentPlayer);
            // Check if the current player has won the game
            boolean isWinner = board.checkWin(row, col, currentPlayer.getPlayingPieceType());
            if (isWinner) {
                board.printBoard();
                winner = currentPlayer;
                return currentPlayer.getName() + " wins!";
            }
        }
        return "The game ended in a tie!";
    }
}
