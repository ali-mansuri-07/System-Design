package com.interviewQuestions.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPieceType[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPieceType[size][size];
    }

    public boolean updateBoard(int row, int col, PlayingPieceType type) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = type;
        return true;
    }

    public boolean checkWin(int row, int col, PlayingPieceType playingPieceType) {
        // check row
        boolean rowMatch = true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null || board[row][i].type != playingPieceType.type) {
                rowMatch = false;
                break;
            }
        }
        // check column
        boolean colMatch = true;
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null || board[i][col].type != playingPieceType.type) {
                colMatch = false;
                break;
            }
        }
        // check diagonal
        boolean diagMatch = (row == col);
        if (diagMatch) {
            for (int i = 0; i < size; i++) {
                if (board[i][i] == null || board[i][i].type != playingPieceType.type) {
                    diagMatch = false;
                    break;
                }
            }
        }
        // check anti-diagonal
        boolean antiDiagMatch = (row + col == size - 1);
        if (antiDiagMatch) {
            for (int i = 0; i < size; i++) {
                if (board[i][size - 1 - i] == null || board[i][size - 1 - i].type != playingPieceType.type) {
                    antiDiagMatch = false;
                    break;
                }
            }
        }
        // return true if any of the matches is true indicating that the current player
        // has won the game
        return rowMatch || colMatch || diagMatch || antiDiagMatch;

    }

    public List<int[]> getFreeCells() {
        List<int[]> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new int[] { i, j });
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].type + " ");
                } else {
                    System.out.print("  ");
                }
                if (j < size - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("---------");
            }
        }
    }

}
