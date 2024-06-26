package com.techcrack.DSA.ArraysAndBS;

public class MinimumRotated {
    //Brute force
    public int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            if(min > num)
                min = num;
        }

        return min;
    }

    //Optimized Solution
    public int findMin(int[] nums) {
        int minimum = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[start] == nums[end] && start != end)
                end--;
            else if(nums[mid] >= nums[start]){
                if(nums[start] < minimum)
                    minimum = nums[start];
                start = mid + 1;
            }
            else
                end = mid;
        }

        return minimum;
    }


    //Code Optimized
    public int findMin3(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (start + end) / 2;
            if(nums[end] > nums[mid])
                end = mid;
            else if(nums[end] < nums[mid])
                start = mid + 1;
            else
                end--;
        }

        return nums[start];
    }
}
