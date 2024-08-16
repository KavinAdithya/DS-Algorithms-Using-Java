package com.techcrack.DSA.Patterns;

public class Triangle {

    public static void triangle(int length) {
        int overAllLength = length * 2 + 1;

        for (int i = 1; i < overAllLength; i += 2 ) {
            for (int j = 1; j < length; j++)
                System.out.print(" ");
            for (int k = 1; k < i + 1; k++)
                System.out.print("*");
            System.out.println();
            length--;
        }
    }

    public static void main(String[] args) {
        triangle(5);
    }
}
