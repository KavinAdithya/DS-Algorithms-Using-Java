package com.techcrack.DSA.strings;

import java.util.HashMap;
import java.util.Map;

class BinarySubArray {

    // Brute Force Solution -> O(n^2)
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int subArray = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int sum = 0;

            for (int j = i; j < length; j++) {
                sum += nums[j];

                if (sum == goal)
                    subArray++;
                if (sum > goal)
                    break;
            }
        }

        return subArray;
    }



    // Optimized solution
    // Time complexity O(n)
    // Space Complexity O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal) {
        int count = 0;

        int i = 0;
        int j = 0;

        int length = nums.length;
        int sum = 0;

        while (j < length) {
            sum += nums[j];

            while (i <= j && sum > goal) {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);
            j++;
        }


        return count;
    }

    // Brute Force
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int subarrayCount = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int localGoal = 0;
            int j = i;

            for (; j < length; j++) {
                localGoal += nums[j];

                if (localGoal == goal)
                    subarrayCount++;

                if (localGoal > goal)
                    break;
            }

        }

        return subarrayCount;
    }

    public int numSubarraysWithSum56(int[] nums, int goal) {
        return atMost1(nums, goal) - atMost1(nums, goal - 1);
    }

    private int atMost1(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int sum = 0;

        int count = 0;
        int length = nums.length;

        while (j < length) {
            sum += nums[j];

            while (i <= j && sum > goal) {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
    }

    public int numSubarraysWithSum6(int[] nums, int goal) {
        Map<Integer, Integer> hashPrefix = new HashMap<>();

        int prefixSum = 0;
        hashPrefix.put(0, 1);
        int result = 0;

        for (int num : nums) {
            prefixSum += num;
            result += hashPrefix.getOrDefault(prefixSum - goal, 0);

            hashPrefix.put(prefixSum, hashPrefix.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}