package com.techcrack.DSA.Sorting;

import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minCloset = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int k = 0; k < nums.length; k++) {
            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                int locDistance = Math.abs(target - sum);

                if (locDistance <= minDistance) {
                    minCloset = sum;
                    minDistance = locDistance;
                }
                if (sum < target) {
                    i++;
                }
                else
                    j--;
            }
        }

        return minCloset;
    }
}