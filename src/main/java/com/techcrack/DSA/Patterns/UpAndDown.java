package com.techcrack.DSA.Patterns;

public class UpAndDown {
    static void upAndDown(int length) {
        for (int i = 1; i < length + 2; i++) {

            for (int j = 1; j < i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = length; i > 0; i--) {
            for (int j = 1; j < i + 1; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        upAndDown(5);
    }
}
