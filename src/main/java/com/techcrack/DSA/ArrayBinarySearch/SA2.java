package com.techcrack.DSA.ArrayBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SA2 {
    public boolean[] isArraySpecial1(int[] nums, int[][] queries) {
        List<Integer> sameParityIndex = new ArrayList<>();


        for (int i = 1; i < nums.length; i++)
            if (nums[i] % 2 == nums[i - 1] % 2)
                sameParityIndex.add(i);



        boolean[] queriesResult = new boolean[queries.length];

        int i = 0;
        for (int[] query : queries)
            queriesResult[i++] = isAvailableIndex(sameParityIndex, query[0], query[1]);

        return queriesResult;
    }

    public boolean isAvailableIndex(List<Integer> sameParityIndex, int low, int high) {
        int start = 0;
        int end = sameParityIndex.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = sameParityIndex.get(mid);

            if (midValue > low && midValue <= high)
                return false;
            else if (midValue <= low)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return true;
    }


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefixSumNums = new int[nums.length];

        int sameParity = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2)
                sameParity++;
            prefixSumNums[i] = sameParity;
        }

        boolean[] resultQuery = new boolean[queries.length];
        int i = 0;

        for (int[] query : queries)
            resultQuery[i++] = prefixSumNums[query[1]] - prefixSumNums[query[0]] == 0;

        return resultQuery;
    }
}
