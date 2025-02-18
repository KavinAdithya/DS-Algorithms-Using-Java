package com.techcrack.dsa.sorting;

import java.util.Arrays;

class PartitionArray {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        
        return sum;
    }
}