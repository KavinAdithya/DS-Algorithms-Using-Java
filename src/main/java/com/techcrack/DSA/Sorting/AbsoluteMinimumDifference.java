package com.techcrack.DSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AbsoluteMinimumDifference {
    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff)
                minDiff = diff;
        }

        List<List<Integer>> minPair = new ArrayList<>();
        
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff)
                minPair.add(Arrays.asList(arr[i - 1], arr[i]));
        }

        return minPair;
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length < 2)
            return new ArrayList<>();

        Arrays.sort(arr);

        int minimumDifference = Integer.MAX_VALUE;

        List<List<Integer>> minPairs = new ArrayList<>();

        for (int i = 1;  i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff < minimumDifference) {
                minimumDifference = diff;
                // minPairs.clear();
                minPairs = new ArrayList<>();
            }

            if (diff == minimumDifference)
                minPairs.add(Arrays.asList(arr[i - 1], arr[i]));
        }

        return minPairs;
    }
}