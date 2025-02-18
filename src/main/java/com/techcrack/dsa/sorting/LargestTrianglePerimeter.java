package com.techcrack.dsa.sorting;

import java.util.Arrays;

class LargestTrianglePerimeter {
    public int largestPerimeter(int[] nums) {
        int maxPerimeter = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int localPerimeter = 0;
                    int sum = nums[i] + nums[j] + nums[k];
                   
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[k] + nums[j] > nums[i])
                        localPerimeter = sum;
                    
                    if (localPerimeter > maxPerimeter)
                        maxPerimeter = localPerimeter;
                }
            }
        }

        return maxPerimeter;
    }

    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 1; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];

            if (a + b > c)
                return a + b + c;
        }

        return 0;
    }
}