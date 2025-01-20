package com.techcrack.DSA.patterns.recapAgain;

public class P14 {
    public static void hollowInvertedPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            int end = (n - i) * 2 + 1;

            for (int j = 1; j <= end; j++) {
                System.out.print(i == 1 || j == 1 || j == end ? "*" : " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowInvertedPyramid(5);
    }
}
