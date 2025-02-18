package com.techcrack.dsa.recursion.backtrack.maze;

public class SudokuSolve {
    static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }

            System.out.println();
        }

    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num || board[row][i] == num)
                return false;
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    static boolean solve(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmptyAbsent = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmptyAbsent = false;
                    break;
                }
            }
        }

        if (isEmptyAbsent)
            return true;

        for (int i = 1; i <= board.length; i++) {
            board[row][col] = i;

            if (solve(board))
                return true;

            board[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 3, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0 ,0, 7, 9}
        };

        System.out.println(solve(board));

        display(board);
    }
}
