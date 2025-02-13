package com.techcrack.DSA.recursion.backtrack.maze;

public class NQueenAnotherImplementation {

    static void display(boolean[][] table) {
        for (boolean[] row : table) {
            for (boolean t : row) {
                System.out.print(t ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(boolean[][] table, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (table[i][col]) return false;
        }

        int minLeft = Math.min(row, col);

        for (int i = 1; i <= minLeft; i++) {
            if (table[row - i][col - i]) return false;
        }

        int minRight = Math.min(row, table.length - col - 1);

        for (int i = 1; i <= minRight; i++) {
            if (table[row - i][col + i]) return false;
        }

        return true;
    }

    static int nQueen(boolean[][] table, int row) {
        if (row == table.length) {
            display(table);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < table.length; i++) {
            if (isSafe(table, row, i)) {
                table[row][i] = true;

                count += nQueen(table, row + 1);

                table[row][i] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        boolean[][] table = new boolean[n][n];

        System.out.println(nQueen(table, 0));
    }
}
