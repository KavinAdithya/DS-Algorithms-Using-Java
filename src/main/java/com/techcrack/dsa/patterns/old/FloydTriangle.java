package com.techcrack.dsa.patterns;

public class FloydTriangle {

    static void floydTriangle(int length) {
        //int value = 1;

        for (int i = 1; i < length + 1; i++) {
            int value = (i - 1 ) * i  / 2;
            for (int j = 1; j < i + 1; j++)
                System.out.print((value + j) + " ");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        floydTriangle(5);
    }
}
