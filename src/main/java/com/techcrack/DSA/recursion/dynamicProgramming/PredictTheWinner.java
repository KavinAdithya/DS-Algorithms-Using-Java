package com.techcrack.dsa.recursion.dynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner {
    public static boolean winner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int i  = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int diff = 1; diff < n; diff++) {
            for (int left = 0; left < n - diff; left++) {
                int right = left + diff;
                System.out.println(nums[left] - dp[left + 1][right] + " " +(
                        nums[right] - dp[left][right - 1]));
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                                            nums[right] - dp[left][right - 1]);
            }
        }

        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }

        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 9, 2, 3};
//
//        int[] nums = {1, 5, 2};
        System.out.println(winner(nums));
    }

}
