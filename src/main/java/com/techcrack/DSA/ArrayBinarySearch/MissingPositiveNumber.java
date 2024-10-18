package com.techcrack.DSA.ArrayBinarySearch;

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

    public int missingNumber3(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end){
            int mid = (start + end) / 2;

            int smallerNumbers = countSmallerNumbers(nums, mid);
            if(smallerNumbers == mid + 1)
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    public int countSmallerNumbers(int[] nums, int target) {
        int count = 0;

        for (int num : nums)
            if (num <= target)
                count++;

        return count;
    }
}
