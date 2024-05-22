package com.techcrack.DSA.Arrays;

public class FindDuplicatesWithoutUsingConstantSpace {
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;


        while(start < end){
            int mid = (start + end) / 2;
            int count = 0 ;

            for(int n : nums){
                if(n <= mid)
                    count++;
            }

            if(count > mid)
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }
}
