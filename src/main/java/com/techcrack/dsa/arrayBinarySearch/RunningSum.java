package com.techcrack.dsa.arrayBinarySearch;

public class RunningSum {
    /*
     *Given aan array we needed to sum those elements and store on the array
     */

    public int[] runningSum(int[] nums) {

        for(int k=1;k<nums.length;k++){
            nums[k]=nums[k-1]+nums[k];
        }

        return nums;
    }
}
