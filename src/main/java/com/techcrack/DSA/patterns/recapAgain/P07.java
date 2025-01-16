package com.techcrack.DSA.patterns.recapAgain;

public class P07 {

    public static void invertedRightAlignedTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(" ");

            for (int j = n - i; j > 0; j--)
                System.out.print("*");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedRightAlignedTriangle(5);
    }
}
