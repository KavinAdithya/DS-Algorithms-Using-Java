package com.techcrack.DSA.patterns;

public class AlternateBinaryTriangle {

    static void alternateBinaryTriangle(int length) {


        for (int i  = 1; i < length + 1; i++) {

            byte value = i % 2 == 0 ? (byte) 0 : (byte) 1;

            for (int j = 1; j < i + 1; j++) {
                System.out.print(value + " ");

                value = value == 0 ? (byte) 1 : (byte) 0;
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        alternateBinaryTriangle(5);
    }
}
