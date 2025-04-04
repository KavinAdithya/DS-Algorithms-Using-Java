package com.techcrack.dsa.recursion.practise;

import java.util.Arrays;

class DiceTarget {
    private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;
        countPossibility(dp, n, k , target);

        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }

        return dp[n][target];    
    }

    private void countPossibility(int[][] dp, int n, int k, int target) {
        for (int dice = 1; dice <= n; dice++) {
            for (int curTar = 1; curTar <= target; curTar++) {
                for (int face = 1; face <= k; face++) {

                    if (curTar - face >= 0) {
                        dp[dice][curTar] = (dp[dice][curTar] + dp[dice - 1][curTar - face]) % MOD;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DiceTarget().numRollsToTarget(7, 6, 6

        ));
    }
}