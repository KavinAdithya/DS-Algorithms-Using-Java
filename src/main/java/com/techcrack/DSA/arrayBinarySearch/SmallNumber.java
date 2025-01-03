package com.techcrack.DSA.arrayBinarySearch;

import java.util.HashSet;
import java.util.Set;

public class SmallNumber {
    //Brute force time complexity is O(n*2) space complexity of O(1)
    public int firstMissingPositive(int[] nums) {
        for(int k = 1; k < Integer.MAX_VALUE; k++){
            for(int d = 0; d < nums.length; d++){
                if(k == nums[d])
                    break;
                if(d + 1 == nums.length)
                    return k;
            }
        }

        return 0;
    }

    //Hashing
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> hashing = new HashSet<>();

        for(int num : nums)
            hashing.add(num);

        for(int k = 1; true; k++){
            if(!hashing.contains(k))
                return k;
        }

    }

    //Array hashing
    public int firstMissingPositive2(int[] nums) {
        int[] hashing = new int[nums.length + 1];

        for(int k = 0; k < nums.length; k++)
            if(nums[k] >= 0 && nums[k] <= nums.length )
                hashing[nums[k]]++;

        for(int k = 1; k < hashing.length; k++)
            if(hashing[k] < 1)
                return k;

        if(hashing[0] == 1)
            return nums.length;
        return nums.length + 1;

    }

    //Cyclic sort
    public int firstMissingPositive4(int[] nums) {
        int n = nums.length;
        int k = 0;
        while(k < n){
            if(nums[k] > 0 && nums[k] <= n && nums[k]  != nums[nums[k] - 1])
                swap(nums, nums[k] - 1, k);
            else
                k++;
        }

        return small(nums);
    }

    private int small(int[] nums){
        for(int k = 0; k < nums.length; k++)
            if(nums[k] != k + 1)
                return k + 1;
        return nums.length + 1;
    }

    private void swap(int[] nums, int correctIndex, int k){
        int temp = nums[correctIndex];
        nums[correctIndex] = nums[k];
        nums[k] = temp;
    }
}
