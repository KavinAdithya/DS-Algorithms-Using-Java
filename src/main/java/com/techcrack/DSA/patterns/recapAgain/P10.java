package com.techcrack.DSA.patterns.recapAgain;

public class P10 {
    public static void centeredPyramidSpacePattern(int n) {
        StringBuilder sb = new StringBuilder("* ");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            System.out.println(sb);

            sb.append("* ");
        }
    }

    public static void main(String[] args) {
        centeredPyramidSpacePattern(5);
    }
}
