package com.techcrack.dsa.recursion.dynamicProgramming;

class HandShake {
    public int count(int N) {
        if (N == 0 || N == 2) return 1;

        int total = 0;

        for (int i = 2; i <= N; i += 2) {
            total += count(i - 2) * count(N - i);
        }

        return total;
    }

    public int countDp(int N) {
        if (N % 2 != 0) return 0; // Odd number of people can't do complete handshakes

        int n = N / 2; // Number of pairs
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 0 pairs → 1 way

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }


}
