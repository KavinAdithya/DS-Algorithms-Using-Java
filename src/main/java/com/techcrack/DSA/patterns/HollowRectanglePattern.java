package com.techcrack.DSA.patterns;

public class HollowRectanglePattern {

    static void hollowRectanglePattern(int row, int column) {
        printLine(column);

        printSpace(row, column);

        printLine(column);
    }

    static void printLine(int column) {
        for (int i = 1; i < column + 1; i++)
            System.out.print("*");

        System.out.println();
    }

    static void printSpace(int row, int column) {
        for (int i = 1; i < row - 1; i++) {
            System.out.print("*");

            for (int j = 1; j < column - 1; j++)
                System.out.print(" ");

            System.out.println("*");
        }
    }

    public static void main(String[] args) {
        hollowRectanglePattern(5, 10);
    }
}
