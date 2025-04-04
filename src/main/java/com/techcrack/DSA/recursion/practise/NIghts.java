package com.techcrack.dsa.recursion.practise;

import javax.security.auth.login.AccountException;

public class Nights {
    private static final int[][] DIRECTIONS = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2}
    };

    public static void printBoard(boolean[][] isPlaced) {
        for (boolean[] placed : isPlaced) {
            for (boolean p : placed) {
                System.out.print(p ? "K " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(boolean[][] isPlaced, int row, int col) {
        int n = isPlaced.length;

        for (int[] DIR : DIRECTIONS) {
            int r = row  + DIR[0];
            int c = col + DIR[1];

            if (r >= 0 && r < n && c >= 0 && c < n && isPlaced[r][c]) {
                return false;
            }
        }

        return true;
    }

    public static int nKnights(boolean[][] isPlaced, int n, int k, int r, int c) {
        if (k == 0) {
            printBoard(isPlaced);
            return 1;
        }

        int count = 0;

        for (int i = r;  i < n; i++) {
            for (int j = i == r ? c  : 0; j < n; j++) {
                if (isSafe(isPlaced, i, j)) {
                    isPlaced[i][j] = true;

                    count += nKnights(isPlaced, n, k - 1, i, j + 1);

                    isPlaced[i][j] = false;
                }
            }
        }

        return count;
    }

    public static int kNightUsingCol(boolean[][] isPlaced, int k, int n, int r, int c) {
        if (k == 0) {
            printBoard(isPlaced);
            return 1;
        }

        if (r == n) {
            return 0;
        }

        if (c == n) {
            return kNightUsingCol(isPlaced, k, n, r + 1, 0);
        }

        int count = 0;
        if (isSafe(isPlaced, r, c)) {
            isPlaced[r][c] = true;
            count += kNightUsingCol(isPlaced, k - 1, n, r, c + 1);
            isPlaced[r][c] = false;
        }

        return count + kNightUsingCol(isPlaced, k, n, r, c + 1);
    }

    public static void main(String[] args) {
        int n = 4;

        boolean[][] isPlaced = new boolean[n][n];

        System.out.println(kNightUsingCol(isPlaced, n, n, 0,0));

    }
}
