package com.techcrack.dsa.recursion.backtrack.maze;

public class ChessEngine {
    private static final int[][] ROOK = {
            {0, -1}, {0, -2}, {0, -3},
            {-1, 0}, {-2, 0}, {-3, 0},
            {0, 1},  {0, 2},  {0, 3},
            {1, 0},  {2, 0},  {3, 0}
    };

    private static final int[][] KNIGHT = {
            {-1, -2}, {-1, 2},
            {-2, -1}, {-2, 1},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
    };

    private static final int[][] BISHOP = {
            {-1, -1}, {-2, -2}, {-3, -3},
            {-1, 1}, {-2, 2}, {-3, 3},
            {1, -1}, {2, -2}, {3, -3},
            {1, 1}, {2, 2}, {3, 3}
    };


    private static int whitePlace(int[][] board, int[][] MOVES, int r, int c, int k, int m ) {
        if (board[r][c] == -1) {
            return m;
        }

        if (k == m) {
            return Integer.MAX_VALUE;
        }

        int minMove = Integer.MAX_VALUE;

        int val = board[r][c];
        board[r][c] = 100;

        for (int[] DIR : MOVES) {
            int r1 = r + DIR[0];
            int c1 = c + DIR[1];

            if (r1 >= 0 && c1 >= 0 && r1 < 4 && c1 < 4 && (board[r1][c1] == -1 || board[r1][c1] == 0)) {
                int move = whitePlace(board, MOVES, r1, c1, k, m + 1);
                minMove = Math.min(minMove, move);
            }
        }

        board[r][c] = val;

        return minMove;
    }

    private static int blackPlace(int[][] board, int[][] MOVES, int r, int c, int k, int m ) {
        if (board[r][c] == 1) {
            return m;
        }

        if (k == m) {
            return Integer.MAX_VALUE;
        }

        int minMove = Integer.MAX_VALUE;

        int val = board[r][c];
        board[r][c] = 100;

        for (int[] DIR : MOVES) {
            int r1 = r + DIR[0];
            int c1 = c + DIR[1];

            if (r1 >= 0 && c1 >= 0 && r1 < 4 && c1 < 4 && (board[r1][c1] == 1 || board[r1][c1] == 0)) {
                int move = blackPlace(board, MOVES, r1, c1, k, m + 1);
                minMove = Math.min(minMove, move);
            }
        }

        board[r][c] = val;

        return minMove;
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, 0, 0, 0},
                {0, 0, 0, 0},
                {3, 0, 0, 0},
                {0, 1, 0, 0}
        };

        System.out.println(whitePlace(board, BISHOP, 2, 0, 3, 0));
    }
}

