package com.techcrack.dsa.recursion.practise;

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

    public static boolean isSafePlace(boolean[][] board, int n, int r, int c) {
        for (int[] d : DIRECTIONS) {
            int row = d[0] + r;
            int col = d[1] + c;

            if (row >= 0 && row < n && col >= 0 && col < n && board[row][col]) {
                return false;
            }
        }

        return true;
    }

    public static int nights(boolean[][] board, int n, int kNight, int r, int c) {
        if (kNight == 0) {
            printBoard(board);
            return 1;
        }

        if (n == r) {
            return 0;
        }

        if (c == n) {
            return nights(board, n, kNight, r + 1, 0);
        }

        int count = 0;

        if (isSafePlace(board, n, r, c)) {
            board[r][c] = true;
            count = nights(board, n, kNight - 1, r, c + 1);
            board[r][c] = false;
        }

        return count + nights(board, n, kNight, r, c + 1);
    }

    public static void main(String[] args) {
        int n = 4;

        boolean[][] isPlaced = new boolean[n][n];

        System.out.println("First ");
//        System.out.println(kNightUsingCol(isPlaced, n, n, 0,0));
        System.out.println("Next");
        System.out.println(nights(isPlaced, n, n, 0, 0));

    }
}
