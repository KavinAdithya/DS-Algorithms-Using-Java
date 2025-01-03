package com.techcrack.DSA.patterns;

public class TriangleDownBetweenSpace13 {

    static void triangleDownBetweenSpace(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++)
                System.out.print(" ");
            for (int k = 0; k < i + 1; k++) {
                if (k == 0 || k == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            System.out.println();
        }

        for (int i = 0; i < length * 2 + 1; i++)
            System.out.print("*");
    }

    public static void main(String[] args) {
        triangleDownBetweenSpace(10);
    }
}
