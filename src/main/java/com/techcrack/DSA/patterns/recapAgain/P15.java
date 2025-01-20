package com.techcrack.DSA.patterns.recapAgain;

public class P15 {
    public static void hollowDiamondTop(int n) {
        int end = n * 2;

        for (int i = 1; i < end; i += 2) {
            for (int j = i; j < end; j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j == 1 || j == i ? "*" : " ");
            }

            System.out.println();
        }
    }

    public static void hollowDiamondBottom(int n) {
        int end = n * 2 - 1;

        for (int i = end; i > 0; i -= 2) {
            for (int j = i; j <= end + 2; j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j == 1 || j == i ? "*" : " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowDiamondTop(5);
        hollowDiamondBottom(4);
    }
}
