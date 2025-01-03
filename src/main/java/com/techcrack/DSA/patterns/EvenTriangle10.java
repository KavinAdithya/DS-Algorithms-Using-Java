package com.techcrack.DSA.patterns;

import java.util.Scanner;

public class EvenTriangle10 {

    static void evenTriangle(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--)
                System.out.print(" ");
            for (int k = 0; k < i + 1; k++)
                System.out.print("* ");
            System.out.println();
        }
    }

    static void evenTriangleDown(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i + 1; j++)
                System.out.print(" ");
            for (int k = length; k > i ; k--)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextByte();
        evenTriangle(length);
        evenTriangleDown(length);
    }
}
