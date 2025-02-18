package com.techcrack.dsa.patterns.allPattern;

public class P01 {
    static void square(int n) {
        StringBuilder sb = new StringBuilder(n);

        sb.append("*".repeat(Math.max(0, n)));

        for (int i = 0; i < n; i++) {
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        square(7);
    }
}
