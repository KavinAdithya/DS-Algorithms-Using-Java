package com.techcrack.DSA.patterns.recapAgain;

public class P03 {

    static void reversePyramidOrInverseRightTriangle(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = n - i; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        reversePyramidOrInverseRightTriangle(5);
    }
}
