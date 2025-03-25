package com.techcrack.dsa.revisit;

public class NKnight {
    private static final int[][] DIRECTIONS = {
            {-1, -2},
            {-1, 2},
            {-2, 1},
            {-2, -1},
    };

    private static void displayBoard(boolean[][] isPlaced, int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(isPlaced[i][j] ? "K " : "X ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static boolean isSafe(boolean[][] isPlaced, int n, int r, int c) {
        for (int[] d : DIRECTIONS) {
            int row = r + d[0];
            int col = c + d[1];

            if (row < 0 || row >= n || col < 0 || col >= n)
                continue;

            if (isPlaced[row][col])
                return false;
        }

        return true;
    }

    private static int kNight(boolean[][] isPlaced, int n, int r, int c, int knights) {
        if (knights == 0) {
            displayBoard(isPlaced, n);
            return 1;
        }

        int count = 0;

        for (int j = r; j < n; j++) {
            for (int i = (j == r) ? c : 0; i < n; i++) {

                if (isSafe(isPlaced, n, j, i)) {

                    isPlaced[j][i] = true;
                    count += kNight(isPlaced, n, j, i + 1, knights - 1);
                    isPlaced[j][i] = false;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        boolean[][] isPlaced = new boolean[n][n];

        System.out.println(kNight(isPlaced, n, 0, 0, n));
    }
}