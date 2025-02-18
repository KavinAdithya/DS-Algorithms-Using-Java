package com.techcrack.dsa.patterns;

public class SymmetricDiamondPattern {
    public static void symmetricDiamond(int length) {
        printTop(length);
        printBottom(length);
    }

    private static void printTop(int length) {
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length - i + 2; j++)
                System.out.print(" ");

            for (int j = i; j > 0; j--)
                System.out.print(j);

            for (int j = 2; j < i + 1; j++)
                System.out.print(j);

            System.out.println();
        }
    }

    private static void printBottom(int length) {
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < i + 2; j++)
                System.out.print(" ");

            for (int j = length - i; j > 0; j--)
                System.out.print(j);

            for (int j = 2; j < length - i + 1; j++)
                System.out.print(j);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        symmetricDiamond(4);
    }
}
