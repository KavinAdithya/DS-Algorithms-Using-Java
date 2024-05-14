package com.techcrack.DSA.Arrays;

public class MinimumSortedArray {
    public int findMin(int[] nums) {
        int minimumValue=Integer.MAX_VALUE;

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            int localMinimum=0;
            if(nums[mid]>=nums[start]){
                localMinimum=nums[start];
                start=mid+1;
            }
            else{
                localMinimum=nums[mid];
                end=mid-1;
            }
            if(localMinimum<minimumValue)
                minimumValue=localMinimum;
        }

        return minimumValue;
    }
}
