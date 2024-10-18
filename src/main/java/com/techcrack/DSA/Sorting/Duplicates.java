package com.techcrack.DSA.Sorting;

import java.util.*;

class Duplicates {
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> numsHash = new HashMap<>();

        for (int n : nums) {
            int value = numsHash.getOrDefault(n, 0);
            numsHash.put(n, value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numsHash.entrySet()) {
            if (entry.getValue() > 1)
                return true;
        }

        return false;
    }
}