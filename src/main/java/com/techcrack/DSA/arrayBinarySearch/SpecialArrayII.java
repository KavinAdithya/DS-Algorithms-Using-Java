package com.techcrack.DSA.arrayBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArrayII {

    //Brute Force
    public boolean[] isArraySpecial1(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];

        Arrays.fill(result, true);

        for(int k = 0; k < queries.length; k++){
            for(int v = queries[k][0] + 1; v <= queries[k][1]; v++){
                if(nums[v - 1] % 2 == nums[v] % 2){
                    result[k] = false;
                    break;
                }
            }
        }

        return result;
    }

    //Optimized but not topic
    public boolean[] isArraySpecial3(int[] nums, int[][] queries) {
        int[] marker = new int[nums.length];
        marker[0] = 1;

        for(int k = 1; k < nums.length; k++){
            if(nums[k] % 2 != nums[k - 1] % 2)
                marker[k] = marker[k - 1] + 1;
            else
                marker[k] = marker[k - 1];
        }

        boolean[] result = new boolean[queries.length];

        for(int k = 0; k < queries.length; k++){
            int start = queries[k][0] ;
            int end = queries[k][1] ;

            if(end - start == marker[end] - marker[start])
                result[k] = true;
        }

        return result;
    }

    //Binary Search
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Integer> index = new ArrayList<Integer>();

        for(int k = 1; k < nums.length; k++){
            if(nums[k] % 2 == nums[k - 1] % 2)
                index.add(k);
        }

        boolean[] result = new boolean[queries.length];

        for(int k = 0; k < queries.length ; k++){
            int start = queries[k][0] + 1 ;
            int end = queries[k][1];
            if(search(start, end, index))
                result[k] = true;
        }

        return result;
    }

    private boolean search(int start, int end, List<Integer> index){
        int low = 0;
        int high = index.size() - 1;

        while(low <= high){
            int mid = (high + low) / 2;
            int midValue = index.get(mid);

            if(midValue >= start && midValue <= end)
                return false;
            else if(midValue < start)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return true;
    }
}
