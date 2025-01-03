package com.techcrack.DSA.arrayBinarySearch;

public class RotatedSearchArray {
    public boolean search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(nums[mid]==target)
                return true;
            else if(nums[start]==nums[end]){
                if(nums[start]==target)
                    return true;
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]){
                if(nums[mid]>target&&target>=nums[start])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(nums[mid]<target&&target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }

        return false;
    }
}
