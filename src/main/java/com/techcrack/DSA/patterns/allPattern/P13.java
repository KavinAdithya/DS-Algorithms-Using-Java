package com.techcrack.dsa.patterns.allPattern;

public class P13 {

    public static void hollowPyramidPattern(int n) {
        int end = n * 2 - 1;

        for (int i = 1; i <= end; i += 2) {
            for (int j = 1; j <= n - i / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(i == end || j == 1 || j == i ? "*" : " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowPyramidPattern(5);
    }
}