package com.techcrack.dsa.patterns;

public class RectangleRight {

    static void rectangleRight(int length) {

        for (int i = 1; i < length + 1; i++) {
            for (int j = length - i; j > 0; j--)
                System.out.print(" ");
            for (int k = 1; k < i + 1; k++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rectangleRight(7);
    }

}
