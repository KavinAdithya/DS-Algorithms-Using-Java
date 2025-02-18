package com.techcrack.dsa.patterns;

public class RightTriangle {
    static void rightTriangle(int length) {
        for (int i = 1; i < length + 1; i++) {

            for (int j = 0; j < i ; j++) {
                System.out.print("X");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        rightTriangle(4);
    }

}
