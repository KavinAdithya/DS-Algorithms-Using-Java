package com.techcrack.DSA.ArraysAndBS;

public class MissingPositiveNumber {
    public int findKthPositive(int[] nums, int k) {
        int start=0;
        int end=nums.length-1;


        while(start<=end){
            int mid=(start+end)/2;
            int missingCount=(nums[mid]-(mid+1));
            if(missingCount<k)
                start=mid+1;
            else
                end=mid-1;
        }
        if(end==-1)
            return k;
        return nums[end]+ (k-(nums[end]-(end+1)));
    }
}
