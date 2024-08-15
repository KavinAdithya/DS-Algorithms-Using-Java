package com.techcrack.DSA.Strings;

import java.util.HashMap;
import java.util.Map;

class SubarraySumEquals {
    public int subarraySum(int[] nums, int total) {
        int countSubArrays = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int sum = 0;

                for (int k = i; k < j + 1; k++) 
                    sum += nums[k];
                
                if (sum == total)
                    countSubArrays++;
            }
        }

        return countSubArrays;
    }

    public int subarraySum1(int[] nums, int total) {
        int countSubArrays = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];

                if (sum == total)
                    countSubArrays++;
            }
        }

        return countSubArrays;
    }


    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        frequency.put(0, 1);

        int prefixSum = 0;
        int subArrayCount = 0;

        for (int num : nums) {
            prefixSum += num;

            if (frequency.containsKey(prefixSum - k)) {
                subArrayCount += frequency.get(prefixSum - k);
            }

            if (frequency.containsKey(prefixSum)) {
                int value = frequency.get(prefixSum);
                frequency.put(prefixSum, value + 1);
            }
            else
                frequency.put(prefixSum, 1);
        }

        return subArrayCount;

    }
}