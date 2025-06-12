package com.techcrack.dsa.weeklyContest.week453;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    private static final int MOD = 1_000_000_007;

    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];  // dp[i] = ways to partition first i elements
        long[] prefixSum = new long[n + 2]; // prefixSum[i] = sum of dp[0..i-1]

        dp[0] = 1;  // empty prefix has 1 way
        prefixSum[1] = 1;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; ++right) {
            // Maintain min deque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Maintain max deque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Shrink window from left until valid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                left++;
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
            }

            // Now window [left..right] is valid
            dp[right + 1] = (prefixSum[right + 1] - prefixSum[left] + MOD) % MOD;

            // Update prefixSum
            prefixSum[right + 2] = (prefixSum[right + 1] + dp[right + 1]) % MOD;
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(prefixSum));

        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{9, 4, 1, 3, 7}, 4));
    }
}
