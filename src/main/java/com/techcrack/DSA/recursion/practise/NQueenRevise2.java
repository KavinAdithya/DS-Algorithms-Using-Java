package com.techcrack.dsa.recursion.practise;

public class NQueenRevise2 {
    public static void printBoard(boolean[][] isPlaced) {
        for (boolean[] place : isPlaced) {
            for (boolean p : place) {
                System.out.print(p ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int nQueen(boolean[][] isPlaced, int n, int r) {
        if (r == n) {
            printBoard(isPlaced);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isSafe(isPlaced, n, r, i)) {
                isPlaced[r][i] = true;
                count += nQueen(isPlaced, n, r + 1);
                isPlaced[r][i] = false;
            }
        }

        return count;
    }

    public static boolean isSafe(boolean[][] isPlaced, int n, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (isPlaced[i][c]) {
                return false;
            }
        }
        int left = Math.min(r, c);
        int right = Math.min(r, n - c - 1);

        for (int i = 1; i <= left; i++) {
            if (isPlaced[r - i][c - i]) {
                return false;
            }
        }

        for (int i = 1; i <= right; i++) {
            if (isPlaced[r - i][c + i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        boolean[][] isPlaced = new boolean[n][n];

        System.out.println(nQueen(isPlaced, n, 0));
    }
}
