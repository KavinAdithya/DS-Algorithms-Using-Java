package com.techcrack.dsa.revisit;

public class NQueen {
    private static void printBoard(boolean[][] isPlaced, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(isPlaced[i][j] ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(boolean[][] isPlaced, int n, int r, int c) {

//        if (r == 0)
//            return true;

        for (int i = 0; i < r; i++) {
            if (isPlaced[i][c])
                return false;
        }

        int left = Math.min(r, c);

        for (int i = 1; i <= left; i++) {
            if (isPlaced[r - i][c - i]) {
                return false;
            }
        }

        int right = Math.min(n - c, r + 1);

        for (int i = 1; i < right; i++) {
            if (isPlaced[r - i][c + i]) {
                return false;
            }
        }

        return true;
    }

    private static int placeQueens(boolean[][] isPlaced, int n, int r) {
        if (r == n) {
            printBoard(isPlaced, n);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isSafe(isPlaced, n, r, i)) {
                isPlaced[r][i] = true;
                count += placeQueens(isPlaced, n, r + 1);
                isPlaced[r][i] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n  = 10;
        boolean[][] isPlaced = new boolean[n][n];

        System.out.println(placeQueens(isPlaced, n, 0));
    }
}
