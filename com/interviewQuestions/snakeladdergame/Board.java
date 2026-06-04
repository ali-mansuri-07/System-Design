package com.interviewQuestions.snakeladdergame;

public class Board {
    protected Cell[][] cells;
    private int size;

    public Board(int size, int snakes, int ladders) {
        this.size = size;
        cells = new Cell[size][size];

        initializeCells();
        addSnakesLadders(cells, snakes, ladders);
    }

    private void initializeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells, int snakes, int ladders) {
        // Add snakes
        for (int i = 0; i < snakes; i++) {
            int snakeStart = (int) (Math.random() * (size - 1)) + 1; // Random start position for snake
            int snakeEnd = (int) (Math.random() * (snakeStart - 1)) + 1; // Random end position for snake (must be less
                                                                         // than start)
            if (snakeStart >= snakeEnd) {
                continue; // Skip if snake start is not greater than end
            }
            Jump snakeObj = new Jump(snakeStart, snakeEnd);

            Cell cell = getCell(snakeStart);
            cell.jump = snakeObj;

            snakes--;
        }

        // Add ladders
        for (int i = 0; i < ladders; i++) {
            int ladderStart = (int) (Math.random() * (size - 1)) + 1; // Random start position for ladder
            int ladderEnd = (int) (Math.random() * (size - ladderStart)) + ladderStart + 1; // Random end position for
                                                                                            // ladder (must be greater
                                                                                            // than start)
            if (ladderStart >= ladderEnd) {
                continue; // Skip if ladder start is not greater than end
            }
            Jump ladderObj = new Jump(ladderStart, ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            ladders--;
        }
    }

    Cell getCell(int position) {
        int boardRow = (position - 1) / 10;
        int boardCol = (position - 1) % 10;

        return cells[boardRow][boardCol];
    }
}
