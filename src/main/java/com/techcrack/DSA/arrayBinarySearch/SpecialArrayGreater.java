package com.techcrack.DSA.arrayBinarySearch;

//You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
//
//Notice that x does not have to be an element in nums.
//
//Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
public class SpecialArrayGreater {

    //Brute Force
    public int specialArray1(int[] nums) {
        int max =  0;

        for(int num : nums){
            if(max < num)
                max = num;
        }

        for(int outer = 1; outer <= max; outer++){
            int count = 0;
            for(int inner = 0; inner < nums.length; inner++){
                if(outer <= nums[inner])
                    count++;
            }
            if(count == outer)
                return count;
        }

        return -1;
    }

    //hashing
    public int specialArray2(int[] nums) {
        int max = 0;
        for(int num : nums){
            if(num > max)
                max = num;
        }

        int[] array = new int[max + 1];

        for(int index = 0; index < nums.length; index++)
            array[nums[index]]++;

        for(int index = max - 1; index >= 0; index--)
            array[index] += array[index + 1];

        for(int index = 1; index <= max; index++){
            if(index == array[index])
                return index;
        }

        return -1;
    }

    //Optimized Binary Search Solution
    public int specialArray(int[] nums) {
        int start = 0;
        int end = 0;

        for(int num : nums){
            if(end < num)
                end = num;
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int maxCount = countMax(nums, mid);
            if(maxCount == mid)
                return mid;
            else if(maxCount > mid)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    private int countMax(int[] nums, int target){
        int count = 0;
        for(int num : nums){
            if(num >= target)
                count++;
        }
        return count;
    }
}
