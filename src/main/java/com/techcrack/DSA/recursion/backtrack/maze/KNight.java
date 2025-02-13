package com.techcrack.DSA.recursion.backtrack.maze;

public class KNight {
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length
                &&
                col >= 0 && col < board[0].length;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean b : row) {
                System.out.print(b ? "K " : "X ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1])
            return false;

        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1])
            return false;

        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2])
            return false;

        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2])
            return false;

        return true;
    }

    static void kNight(boolean[][] board, int row, int col, int kNight) {
        if (kNight == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row + 1 == board.length && col == board[0].length)
            return;

        if (col == board[0].length) {
            kNight(board, row + 1, 0, kNight);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;

            kNight(board, row, col + 1, kNight - 1);

            board[row][col] = false;
        }

        kNight(board, row , col + 1, kNight);
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        kNight(board, 0, 0, n);
    }
}
