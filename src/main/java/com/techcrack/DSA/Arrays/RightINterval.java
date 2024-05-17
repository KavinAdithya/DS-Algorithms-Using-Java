package com.techcrack.DSA.Arrays;

import java.util.Arrays;
public class RightINterval {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[][] copyInterval = new int[length][3];

        for(int k = 0; k < length; k++){
            copyInterval[k][0] = intervals[k][0];
            copyInterval[k][1] = intervals[k][1];
            copyInterval[k][2] = k;
        }

        Arrays.sort(copyInterval,(a,b)->a[0] - b[0]);

        int[] result = new int[length];

        for(int k = 0;k < length;k++)
            result[copyInterval[k][2]] = binarySearch(copyInterval,k,length-1,copyInterval[k][1]);


        return result;
    }


    private int binarySearch(int[][] intervals,int low,int high,int target){
        int result = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(intervals[mid][0] == target)
                return intervals[mid][2];
            else if(intervals[mid][0] > target){
                result = intervals[mid][2];
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return result;
    }
}
