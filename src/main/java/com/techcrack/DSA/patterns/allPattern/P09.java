package com.techcrack.dsa.patterns.allPattern;

public class P09 {
    public static void invertedPyramidPattern(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedPyramidPattern(0);
    }
}
