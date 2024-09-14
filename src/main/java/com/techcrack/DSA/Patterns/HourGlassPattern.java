package com.techcrack.DSA.Patterns;

public class HourGlassPattern {

    public static void hourGlassPattern(int length) {
        // HourGlassPattern
        System.out.println("\nHourGlassPattern \n");
        printTop(length);
        printBottom(length, true);



        // SandGlass Pattern
        System.out.println("\nSandGlassPattern \n");
        printBottom(length, false);
        printTop(length);
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

    static void printBottom(int length, boolean isHourGlass) {

        int end = length;

        if (isHourGlass)
            end++;

        for (int i = 1; i < end ; i++) {

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
