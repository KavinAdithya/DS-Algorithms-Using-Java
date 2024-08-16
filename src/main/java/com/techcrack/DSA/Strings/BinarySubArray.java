package com.techcrack.DSA.Strings;

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
}