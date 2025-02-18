package com.techcrack.dsa.dynamicProgramming;

public class PerfectSquares {

    // Dynamic Programming Top-Down Approach Brute Force
    private static int countSquare(int n) {
        int min = n;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, countSquare(n - i * i) + 1);
        }

        return min;
    }

    private static int dpSquares(int[] dp, int n) {
        if (dp[n] != 0)
            return dp[n];

        int min = n;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, dpSquares(dp, n - i * i) + 1);
        }

        return dp[n] = min;
    }


    // Bottom-Up Approach

    private static int dpSquaresBottom(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public int numSquares(int n) {
        if (isPerfectSquare(n))
            return 1;

        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i))
                return 2;
        }

        for (int i = 1; i * i <= n;  i++) {
            for (int j = 1; j * j <= n - i * i; j++) {
                if (isPerfectSquare(n - i * i - j * j))
                    return 3;
            }
        }

        return 4;
    }

    private boolean isPerfectSquare(int n) {
        int val = (int)Math.sqrt(n);

        return val * val == n;
    }

    public int numSquares1(int n) {

        if (isPerfectSquare(n))
            return 1;

        int m = n;

        while (m % 4 == 0)
            m /= 4;

        if (m % 8 == 7)
            return 4;

        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i))
                return 2;
        }

        return 3;
    }
    public static void main(String[] args) {
//        int count = countSquare(12);
//        System.out.println(count);
//        int n = 12;
//        int[] dp = new int[n + 1];
//
//        System.out.println(dpSquares(dp, n));
//        System.out.println(Arrays.toString(dp));

        System.out.println(dpSquaresBottom(12));
    }



}
