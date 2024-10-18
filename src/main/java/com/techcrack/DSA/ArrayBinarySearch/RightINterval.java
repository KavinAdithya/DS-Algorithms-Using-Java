package com.techcrack.DSA.ArrayBinarySearch;

import java.util.Arrays;
public class RightINterval {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[][] interval = new int[length][3];

        for(int k = 0; k < length; k++){
            interval[k][0] = intervals[k][0];
            interval[k][1] = intervals[k][1];
            interval[k][2] = k;
        }

        Arrays.sort(interval, (a,b) -> a[0] - b[0]);

        int[] result = new int[length];

        for(int k = 0; k < length; k++){
            result[interval[k][2]] = findIndex(interval[k][1], k, length - 1,interval);
        }

        return result;
    }

    private int findIndex(int target, int start, int end, int[][] interval){
        int foundIndex = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(interval[mid][0] >= target){
                foundIndex = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        if(foundIndex == -1)
            return -1;
        return interval[foundIndex][2];
    }

}
