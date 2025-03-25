package com.techcrack.dsa.recursion.backtrack.maze;

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

    static int kNight(boolean[][] board, int row, int col, int kNight) {
        if (kNight == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        if (row + 1 == board.length && col == board[0].length)
            return 0;

        if (col == board[0].length) {
            return kNight(board, row + 1, 0, kNight);
//            return ;x
        }

        int count = 0;

        if (isSafe(board, row, col)) {
            board[row][col] = true;

            count = kNight(board, row, col + 1, kNight - 1);

            board[row][col] = false;
        }

        count += kNight(board, row , col + 1, kNight);

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];

        System.out.println(kNight(board, 0, 0, n));
    }
}
