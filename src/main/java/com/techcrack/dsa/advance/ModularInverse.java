package com.techcrack.dsa.advance;

public class ModularInverse {
    private static int bruteForce(int a, int m) {

        for (int x = 1; x < m; x++) {
            if (a * x % m == 1)
                return x;
        }

        return -1;
    }

    public static void main(String[] args) {
        int a = 3;
        int m = 7;

        System.out.println(bruteForce(a, m));
    }
}
