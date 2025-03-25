package com.techcrack.dsa.recursion.backtrack.maze;

public class Nights {
    private static final int[][] DIRECTIONS = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2}
    };

    static void printBoard(boolean[][] isPlaced) {
        for (boolean[] place : isPlaced) {
            for (boolean isAvailable : place) {
                System.out.print(isAvailable ? "K " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(boolean[][] isPlaced, int r, int c) {
        int n = isPlaced.length;

        for (int[] d : DIRECTIONS) {
            int row = r + d[0];
            int col = c + d[1];

            if (row >= 0 && row < n && col >= 0 && col < n && isPlaced[row][col])
                return false;
        }

        return true;
    }

    static int nights(boolean[][] isPlaced, int r, int c, int nights) {
        if (nights == 0) {
            printBoard(isPlaced);
            return 1;
        }

        int n = isPlaced.length;

        if (c == n) {
            if (r + 1 == n)
                return 0;
            return nights(isPlaced, r + 1, 0, nights);
        }

        int count = 0;

        if (isSafe(isPlaced, r, c)) {
            isPlaced[r][c] = true;
            count += nights(isPlaced, r, c + 1, nights - 1);
            isPlaced[r][c] = false;
        }

        return count + nights(isPlaced, r, c + 1, nights);
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] isPlaced = new boolean[n][n];

        System.out.println(nights(isPlaced, 0,0, n));
    }
}
