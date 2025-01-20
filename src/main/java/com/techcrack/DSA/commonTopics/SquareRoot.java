package com.techcrack.DSA.commonTopics;

public class SquareRoot {
    static double squareLinear(int n) {
        double end = n + 1 / 2;
        double start = 1;

        double increment = 0.001;

        while (start * start < end) {
            start += increment;

            System.out.println(start);
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(squareLinear(8));
    }
}
