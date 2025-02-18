package com.techcrack.dsa.arrayBinarySearch;

import java.util.ArrayList;
import java.util.List;

class SP2 {

    // PrefixSum
    // Time Complexity -> 0(n)
    // Space Complexity -> 0(n)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int sameParity = 0;

        int[] prefixSum = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2)
                sameParity++;
            
            prefixSum[i] = sameParity;
        }

       


        boolean[] result = new boolean[queries.length];

        int i = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];


            if (prefixSum[end] == prefixSum[start])
                result[i] = true;
            i++;
        }

        return result;
    }


    // Binary Search
    // Time Complexity -> 0(nlog(n))
    // space Complexity -> 0(n)
    public boolean[] isArraySpecial1(int[] nums, int[][] queries) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2)
                list.add(i);
        }

        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0] + 1;
            int end = queries[i][1];

            if (isSpecial(list, start, end))
                result[i] = true;
        }


        return result;
    }

    public boolean isSpecial(List<Integer> list, int low, int high) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = list.get(mid);

            if (midValue >= low && midValue <= high)
                return false;
            else if (midValue < low)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return true;
    }
}