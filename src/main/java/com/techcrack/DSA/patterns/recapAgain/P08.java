package com.techcrack.DSA.patterns.recapAgain;

public class P08 {

    public static void centeredAlignedPyramid(int n) {
        StringBuilder sb = new StringBuilder("*");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");

            System.out.println(sb);

            sb.append(" * *");
        }
    }

    public static void main(String[] args) {
        centeredAlignedPyramid(6);
    }
}
