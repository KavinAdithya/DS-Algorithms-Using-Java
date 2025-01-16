package com.techcrack.DSA.patterns.recapAgain;

public class P04 {

    static void numberRightTriangleOrPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        numberRightTriangleOrPyramid(5);
    }
}
