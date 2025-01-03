package com.techcrack.DSA.strings;

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

    // Brute force
    public int subarraySum3(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k)
                    count++;
            }


        }

        return count;
    }

    public int subarraySum4(int[] nums, int k) {
        Map<Integer, Integer> hashing = new HashMap<>();

        hashing.put(0, 1);

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            int required = prefixSum - k;

            if (hashing.containsKey(required))
                result += hashing.get(required);

            int value = 1;

            if (hashing.containsKey(prefixSum))
                value += hashing.get(prefixSum);

            hashing.put(prefixSum, value);
        }

        return result;
    }
}