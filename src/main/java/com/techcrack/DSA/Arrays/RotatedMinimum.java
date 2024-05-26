package com.techcrack.DSA.Arrays;

public class RotatedMinimum {
    public int findMin(int[] nums){

        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] > nums[end])
                start = mid + 1;
            else if (nums[mid] < nums[end])
                end =  mid;
            else
                end--;
        }
        return nums[end];
    }
    // Brute Force
    // public int findMin(int[] nums) {
    //     int min = nums[0];

    //     for(int num : nums){
    //         if(min > num)
    //             min = num;
    //     }

    //     return min;
    // }
}
