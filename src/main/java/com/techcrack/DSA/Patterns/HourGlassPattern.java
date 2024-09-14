package com.techcrack.DSA.Patterns;

public class HourGlassPattern {

    public static void hourGlassPattern(int length) {
        printTop(length);
        printBottom(length);
    }

    static void printTop(int length) {

        for (int i = 1; i < length + 1; i++) {

            for (int j = i; j < length + 1; j++)
                System.out.print("*");

            for (int j = 1; j < (i - 1) * 2 + 1; j++)
                System.out.print(" ");

            for (int j = i; j < length + 1; j++)
                System.out.print("*");

            System.out.println();
        }
    }

    static void printBottom(int length) {

        for (int i = 1; i < length + 1; i++) {

            for (int j = 1; j < i + 1; j++)
                System.out.print("*");

            for (int j = 1; j < (length - i) * 2 + 1; j++)
                System.out.print(" ");

            for (int j = 1; j < i + 1; j++)
                System.out.print("*");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        hourGlassPattern(5);
    }
}
