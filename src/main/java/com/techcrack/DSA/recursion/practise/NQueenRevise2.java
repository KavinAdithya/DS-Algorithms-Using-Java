package com.techcrack.dsa.recursion.practise;

import java.util.HashSet;
import java.util.Set;

public class NQueenRevise2 {
    private static final Set<Integer> col = new HashSet<>();
    private static final Set<Integer> leftSide = new HashSet<>();
    private static final Set<Integer> rightSide = new HashSet<>();

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


    public static void print(boolean[][] board) {
        for (boolean[] r : board) {
            for (boolean c : r) {
                System.out.print((c ? 'Q' : 'X') + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void queen(boolean[][] board, int n, int r) {
        if (r == n) {
            print(board);
            return;
        }

        for (int c = 0; c < n; ++c) {
            int left = r - c;
            int right = r + c;

            if (col.contains(c) || leftSide.contains(left) || rightSide.contains(right)) {
                continue;
            }

            col.add(c);
            leftSide.add(left);
            rightSide.add(right);
            board[r][c] = true;

            queen(board, n, r + 1);

            col.remove(c);
            leftSide.remove(left);
            rightSide.remove(right);
            board[r][c] = false;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] isPlaced = new boolean[n][n];

       queen(isPlaced, n, 0);
    }
}
