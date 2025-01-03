package com.techcrack.DSA.patterns;

public class RightTriangleNumber {
    static void rightTriangleNumber(int length) {
        for (int i = 1; i < length + 1; i++) {
            for(int j = 1; j < i + 1; j++)
                System.out.print(j);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        rightTriangleNumber(7);
    }

}
