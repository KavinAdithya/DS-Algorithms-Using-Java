package com.techcrack.DSA.ArraysAndBS;

import java.util.Arrays;

public class FrequencyOfAnElement {
    public int maxFrequency(int[] nums, int k) {
        int maximumFrequency = 0;

        Arrays.sort(nums);

        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            prefixSum[i] = prefixSum[ i - 1] + nums[i];


        for (int i = 0; i < nums.length; i++)
            maximumFrequency = Math.max(maximumFrequency, countFrequencyPossible(nums, prefixSum, i, k));

        return maximumFrequency;
    }

    public int countFrequencyPossible(int[] nums, long[] prefixSum, int index, int k) {
        int start = 0;
        int end = index;

        while (start < end) {
            int mid = (start + end) / 2;
            long midValue = (long)(index - mid + 1) * nums[index];
            long actualValue = prefixSum[index] - prefixSum[mid] + nums[mid] + k;

            if (actualValue >= midValue)
                end = mid;
            else
                start = mid + 1;
        }

        return index - start + 1;
    }


    public int maxFrequency1(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int length = nums.length;
        int maxFrequency = 0;
        long sum = 0;

        Arrays.sort(nums);

        while (j < length) {
            sum += nums[j];
            while ((long)(j - i + 1) * nums[j] > sum + k) {
                sum -= nums[i];
                i++;
            }

            maxFrequency = Math.max(maxFrequency, j - i + 1);
            j++;
        }

        return maxFrequency;
    }
}
