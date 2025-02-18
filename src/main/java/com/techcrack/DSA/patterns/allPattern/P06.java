package com.techcrack.dsa.patterns.allPattern;

public class P06 {
    public static void rightAlignedPattern(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = n - i; j > 0; j--)
                System.out.print(" ");

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        rightAlignedPattern(4);
    }
}
