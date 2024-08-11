package com.techcrack.DSA.Patterns;

public class RectangleRightDown {
    static void rectangleRightDown(int length) {
        for (int i = 1; i < length + 1; i++){
            for (int j = 1; j < i ; j++)
                System.out.print(" ");
            for (int k = length - i + 1; k > 0; k--)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rectangleRightDown(5);
    }


}
