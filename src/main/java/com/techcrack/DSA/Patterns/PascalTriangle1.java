package com.techcrack.DSA.Patterns;

public class PascalTriangle1 {
    public static int pascalTriangle(int row, int column) {
        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < column ; i++) {
            numerator *= (row - i);
            denominator *= (i + 1);
        }

        return numerator / denominator;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5 - i; j++)
                System.out.print(" ");

            for (int j = 0; j < i + 1; j++)
                System.out.print(pascalTriangle(i, j) + " ");

            System.out.println();

        }

    }
}
