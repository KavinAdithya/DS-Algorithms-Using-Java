package com.techcrack.DSA.patterns.recapAgain;

public class P02 {

    public static void rightAngleOrPyramid(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append('*');

            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        rightAngleOrPyramid(5);
    }
}
