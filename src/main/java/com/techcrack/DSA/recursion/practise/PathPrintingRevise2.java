package com.techcrack.dsa.recursion.practise;

public class PathPrintingRevise2 {
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {1, 1},
            {0, 1},
            {0, -1}
    };

    private static final char[] PATH_NAME = {'T', 'B', 'D', 'L', 'R'};

    public static int mazeBacktrack(boolean[][] pathVisited, int n, String path, int row, int col) {
        if (row + 1 == n && col + 1 == n) {
            System.out.println(path);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int r = row + DIRECTIONS[i][0];
            int c = col + DIRECTIONS[i][1];

            if (isSafe(pathVisited, n, r, c)) {
                pathVisited[r][c] = true;
                count += mazeBacktrack(pathVisited, n, path + PATH_NAME[i], r, c);
                pathVisited[r][c] = false;
            }

        }

        return count;
    }

    private static boolean isSafe(boolean[][] pathVisited, int n,  int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && !pathVisited[r][c];
    }


    public static int maze(int n, boolean[][] obstacle, String processed, int row, int col) {
        if (obstacle[row][col]) {
            return 0;
        }

        if (row == n && col == n) {
            System.out.println(processed);
            return 1;
        }

        int count = 0;

        if (row + 1 <= n) {
            count += maze(n, obstacle, processed + 'V', row + 1, col);
        }

        if (col + 1 <= n) {
            count += maze(n, obstacle, processed + 'H', row , col + 1);
        }

        if (row + 1 <= n && col + 1 <= n) {
            count += maze(n, obstacle, processed + 'D', row + 1, col + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;

        boolean[][] obstacle = new boolean[n][n];

        System.out.println(mazeBacktrack(obstacle, n, "", 0, 0));

//        obstacle[1][1] = true;
//
//        System.out.println(maze(n, obstacle, "", 0, 0));
    }
}
