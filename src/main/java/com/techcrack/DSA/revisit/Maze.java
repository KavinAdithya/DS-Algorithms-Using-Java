package com.techcrack.dsa.revisit;

public class Maze {
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

    public static void main(String[] args) {
//        System.out.println(countPath(10, 0, 0));

        pathMaze("", 3, 0, 0);
    }
}
