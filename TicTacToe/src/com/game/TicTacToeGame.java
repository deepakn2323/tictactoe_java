package com.game;

import java.util.Scanner;

public class TicTacToeGame {
    private static final int BOARD_SIZE = 3;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", enter row (0-" + (BOARD_SIZE - 1) + ") and column (0-" + (BOARD_SIZE - 1) + "):");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (isWinningMove(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == '-';
    }

    private static boolean isWinningMove(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }

        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }

        // Check diagonals
        if (row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (row + col == BOARD_SIZE - 1 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

