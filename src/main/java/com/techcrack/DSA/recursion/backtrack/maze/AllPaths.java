package com.techcrack.DSA.recursion.backtrack.maze;

public class AllPaths {
    private static int count = 1;

    static int countPath(int row, int col) {
        if ( row == 1 || col == 1) return 1;

        return countPath(row - 1, col) + countPath(row, col - 1);
    }

    static void printPath(String path, int row, int col) {
        if (row == 1 && col == 1)
            System.out.println(count++ + " " + path);

        if (row != 1) printPath(path + 'D', row - 1, col);

        if (col != 1) printPath(path + 'R', row, col - 1);
    }

    static void printPathDiagonal(String processed, int row, int col) {
        if (row == 1 && col == 1)
            System.out.println(processed);

        if (row > 1 && col > 1)
            printPathDiagonal(processed + 'D', row - 1, col - 1);
        if (row > 1)
            printPathDiagonal(processed + 'V', row - 1, col);
        if (col > 1)
            printPathDiagonal(processed + 'H', row, col - 1);
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
//        System.out.println(countPath(row, col));
//        printPath("", row, col);

        printPathDiagonal("", row, col);
    }
}
