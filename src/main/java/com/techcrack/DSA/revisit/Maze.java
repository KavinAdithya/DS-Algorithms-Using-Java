package com.techcrack.dsa.revisit;

public class Maze {
    private static final String[] DIRECTION_NAME = {"TOP ", "BOTTOM ", "LEFT ", "RIGHT "};
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int countPath(int n, int r, int c) {
        if (r + 1 == n || c + 1 == n)
            return 1;

        return countPath(n, r + 1, c ) +
                countPath(n, r, c + 1) +
                countPath(n, r + 1, c + 1);
    }

    public static void pathMaze(String path, int n, int r, int c) {
        if (n == r + 1 && c + 1 == n) {
            System.out.println(path);
        }

        if (r + 1 < n) {
            pathMaze(path + 'H', n, r + 1, c);
        }

        if (c + 1 < n) {
            pathMaze(path + 'V', n, r, c + 1);
        }

        if (r + 1 < n && c + 1 < n) {
            pathMaze(path + 'D', n, r + 1, c + 1);
        }
    }

    public static void mazeWithObstacles(String path, boolean[][] isWater, int n, int r, int c) {
        if (c + 1 == n && r + 1 == n) {
            System.out.println(path);
        }

        if (r + 1 < n && ! isWater[r + 1][c]) {
            mazeWithObstacles(path + 'H', isWater, n, r + 1, c);
        }

        if (c + 1 < n && ! isWater[r][c + 1]) {
            mazeWithObstacles(path + 'V', isWater, n, r, c + 1);
        }

        if (r + 1 < n && c + 1 < n && ! isWater[r + 1][c + 1]) {
            mazeWithObstacles(path + 'D', isWater, n, r + 1, c + 1);
        }
    }

    public static void backtrack(String path, boolean[][] isVisited, int n, int r, int c) {
        if (c + 1 == n && r + 1 == n) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int row = r + DIRECTIONS[i][0];
            int col = c + DIRECTIONS[i][1];

            if (row >= 0 && row < n && col >= 0 && col < n && ! isVisited[row][col]) {
                isVisited[row][col] = true;
                backtrack(path + DIRECTION_NAME[i], isVisited, n, row, col);
                isVisited[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(countPath(10, 0, 0));

//        pathMaze("", 3, 0, 0);

        boolean[][] isWater = {
                                {false, false, false},
                                {false, false, false},
                                {false, false, false}
                                };
//        mazeWithObstacles("", isWater, 3, 0, 0);

        backtrack("", isWater, 3, 0, 0);
    }
}
