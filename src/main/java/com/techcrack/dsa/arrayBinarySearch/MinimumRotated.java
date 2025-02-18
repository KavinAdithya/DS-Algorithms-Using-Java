package com.techcrack.dsa.arrayBinarySearch;

public class MinimumRotated {
    //Brute force
    public int findMin1(int[] numb) {
        int min = Integer.MAX_VALUE;

        for(int num : numb){
            if(min > num)
                min = num;
        }

        return min;
    }

    //Optimized Solution
    public int findMin(int[] numb) {
        int minimum = Integer.MAX_VALUE;

        int start = 0;
        int end = numb.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(numb[start] == numb[end] && start != end)
                end--;
            else if(numb[mid] >= numb[start]){
                if(numb[start] < minimum)
                    minimum = numb[start];
                start = mid + 1;
            }
            else
                end = mid;
        }

        return minimum;
    }


    //Code Optimized
    public int findMin3(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (start + end) / 2;
            if(nums[end] > nums[mid])
                end = mid;
            else if(nums[end] < nums[mid])
                start = mid + 1;
            else
                end--;
        }

        return nums[start];
    }
}
