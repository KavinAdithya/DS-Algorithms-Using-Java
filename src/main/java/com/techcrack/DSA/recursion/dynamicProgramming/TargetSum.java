package com.techcrack.dsa.recursion.dynamicProgramming;

import java.util.Arrays;

public class TargetSum {


    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        int[][] dp = new int[nums.length][2 * totalSum + 1];

        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        System.out.println(Arrays.toString(dp[0]));

        for (int index = 1; index < nums.length; index++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[index - 1][sum + totalSum] > 0) {
                    dp[index][sum + nums[index] + totalSum] += dp[index - 1][sum + totalSum];

                    dp[index][sum - nums[index] + totalSum] += dp[index - 1][sum + totalSum];

                }
            }

            System.out.println(Arrays.toString(dp[index]));
        }

        return Math.abs(target) > totalSum ? 0 : dp[nums.length - 1][target + totalSum];
    }

    static int findTarget1D(int[] nums, int target) {
        int sum = Arrays.stream(nums)
                        .sum();

        if (target > sum || (sum + target) % 2 == 1) return 0;

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};

        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
}
