package com.techcrack.DSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class IntervalsMerge {
    public int[][] merge1(int[][] intervals) {
        int n = intervals.length;

        Comparator<int[]> compareTo = ((a, b) -> a[0] - b[0]);

        Arrays.sort(intervals, compareTo);

        List<int[]> mergedIntervals =  new ArrayList<>();

        int i = 0;

        while (i < n) {
            int start = intervals[i][0];

            int end = intervals[i][1];
            
            while (i + 1 != n && end >= intervals[i + 1][0]){
                if (intervals[i + 1][1] > end)
                    end = intervals[i + 1][1];
                i++;    
            }

            mergedIntervals.add(new int[]{start, end});
            i++;
        }

        int[][] mergedArray = new int[mergedIntervals.size()][];

        i = 0;

        for (int[] pair : mergedIntervals) 
            mergedArray[i++] = pair;
        
        return mergedArray;

    }

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];


            if (interval[0] > currentInterval[1]) {
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
            else
                currentInterval[1] = Math.max(interval[1], currentInterval[1]);
        }

        mergedIntervals.add(currentInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}