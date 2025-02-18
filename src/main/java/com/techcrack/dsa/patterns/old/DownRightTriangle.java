package com.techcrack.dsa.patterns;

public class DownRightTriangle {
    static void downRightTriangle(int length) {
        for (int i = length; i > 0; i--) {

            for (int j = 0; j < i; j++)
                System.out.print("A");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        downRightTriangle(4);
    }
}
