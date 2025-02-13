package com.techcrack.DSA.recursion.backtrack.maze;

import java.util.Arrays;

public class AllPossiblePathBackTrack {

    static void allPath(String processed, boolean[][] maze, int row, int col) {
        if (row + 1 == maze.length && col + 1 == maze[0].length) {
            System.out.println(processed);
            return;
        }

        if (! maze[row][col]) return;

//        maze[row][col] = false;

        if (row > 0)
            allPath(processed + 'U', maze, row - 1, col);

        if (col > 0)
            allPath(processed + 'L', maze, row, col - 1);

        if (row + 1 != maze.length)
            allPath(processed + 'D', maze, row + 1, col);

        if (col + 1 != maze[0].length)
            allPath(processed + 'R', maze, row , col + 1);

        maze[row][col] = true;
        // Undoing Changes made
    }

    private static int level = 0;

    static void allPathPrint(String processed, int[][] maze, int row, int col) {
        if (row + 1 == maze.length && col + 1 == maze[0].length) {
            System.out.println(processed);
            maze[row][col] = level + 1;
            printArr(maze);
            maze[row][col] = 0;
            return;
        }

        if (maze[row][col] != 0) return;

        level++;

        maze[row][col] = level;

        if (row > 0)
            allPathPrint(processed + 'U', maze, row - 1, col);

        if (col > 0)
            allPathPrint(processed + 'L', maze, row, col - 1);

        if (row + 1 != maze.length)
            allPathPrint(processed + 'D', maze, row + 1, col);

        if (col + 1 != maze[0].length)
            allPathPrint(processed + 'R', maze, row , col + 1);

        maze[row][col] = 0;
        level--;
        // Undoing Changes made
    }


    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] maze1 = new int[3][3];

        allPathPrint("", maze1, 0, 0);
    }

    static void printArr(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
