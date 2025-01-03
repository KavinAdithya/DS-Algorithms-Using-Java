package com.techcrack.DSA.sorting;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    // Brute Force Approach
    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isMissing(nums, i))
                return i;
        }

        return nums.length;
    }

    static boolean isMissing(int[] nums, int n) {
        for (int num : nums) {
            if (n == num) {
                return false;
            }
        }

        return true;
    }

    // Hashing using Set
    public int missingNumber2(int[] nums) {
        Set<Integer> numHolder = new HashSet<>();

        includeNumbers(numHolder, nums);

        for (int i = 0; i < nums.length; i++) {
            if (! numHolder.contains(i))
                return i;
        }

        return nums.length;
    }

    static void includeNumbers(Set<Integer> numHolder, int[] nums) {
        for (int n : nums) {
            numHolder.add(n);
        }
    }

    public int missingNumber3(int[] nums) {
        boolean[] numHolder = new boolean[nums.length + 1];

        includeNumbers1(numHolder, nums);

        for (int i = 0; i < nums.length; i++) {
            if (! numHolder[i])
                return i;
        }

        return nums.length;
    }

    static void includeNumbers1(boolean[] numHolder, int[] nums) {
        for (int n : nums) {
            numHolder[n] = true;
        }
    }

    public int missingNumber(int[] nums) {
        sortNums(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }

        return nums.length;
    }

    static void sortNums(int[] nums) {
        int i = 0;

        int n = nums.length;

        while (i < n) {
            if (nums[i] != n && i != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
    }

    static void swap(int[] nums, int src, int des) {
        int temp = nums[src];
        nums[src] = nums[des];
        nums[des]  = temp;
    }
}
