package com.techcrack.DSA.Patterns;

public class UpAndDown12 {
    static void upAndDown(int length) {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i + 1; j++)
                System.out.print(" ");
            for (int k = 0; k < length - i; k++)
                System.out.print("* ");
            System.out.println();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++)
                System.out.print(" ");
            for (int k = 0; k < i + 1; k++)
                System.out.print("* ");
            System.out.println();
        }


    }

    public static void main(String[] args) {
        upAndDown(5);
    }
}
