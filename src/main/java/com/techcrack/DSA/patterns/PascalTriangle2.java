package com.techcrack.DSA.patterns;

public class PascalTriangle2 {
    public static void pascalTriangle(int row) {
        int answer = 1;

        System.out.print(1 + " ");
        for (int i = 1; i < row - 1; i++) {
            answer = answer * (row - i) / i;
            System.out.print(answer + " ");
        }
        if (row != 1)
            System.out.println(1);
        else
            System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6 - i; j++)
                System.out.print(" ");
            pascalTriangle(i);
        }

        //pascalTriangle(5);
    }
}
