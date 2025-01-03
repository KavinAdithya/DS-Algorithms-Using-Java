package com.techcrack.DSA.patterns;

public class RectanglePattern {
    static void patternPrinting(int length) {

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        patternPrinting(10);
    }
}
