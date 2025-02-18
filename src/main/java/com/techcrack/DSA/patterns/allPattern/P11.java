package com.techcrack.dsa.patterns.allPattern;

public class P11 {
    public static void invertedCenteredPyramidSpacePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedCenteredPyramidSpacePattern(200);
    }
}
