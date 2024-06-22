package com.techcrack.DSA.ArraysAndBS;

public class GreaterThan {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = 0;
        int min = 0;

        for(int num : nums){

            if(max < num)
                max = num;

            if(min > num)
                min = num;
        }

        int[] result = new int[nums.length];
        int[] hashing = new int[max + 1];

        for(int num : nums)
            hashing[num]++;

        for(int k = 1; k <= max; k++)
            hashing[k] += hashing[k - 1];

        for(int k = 0; k < nums.length; k++){

            if(nums[k] == min)
                result[k] = 0;
            else
                result[k] = hashing[--nums[k]];
        }

        return result;

    }
}