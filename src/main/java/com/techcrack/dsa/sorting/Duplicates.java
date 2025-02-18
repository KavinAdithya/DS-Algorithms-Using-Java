package com.techcrack.dsa.sorting;

import java.util.*;

class Duplicates {

    // Brute force
    public boolean containsDuplicate1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }

    // Sorting
    public boolean containsDuplicate2(int[] nums) {

        if (nums == null || nums.length  <= 1)
            return false;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }

        return false;
    }

    // HashSet
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hashNums = new HashSet<>();

        for (int num : nums) {

            if (hashNums.contains(num))
                return true;

            hashNums.add(num);
        }

        return false;
    }
}