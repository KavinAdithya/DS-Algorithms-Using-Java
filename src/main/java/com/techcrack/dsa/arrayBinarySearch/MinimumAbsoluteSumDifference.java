package com.techcrack.dsa.arrayBinarySearch;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] changer, int[] constant) {
        long minSumDifference = 0;
        int[] sortChanger = new int[changer.length];
        long MOD  = 1_000_000_007;

        for(int k = 0; k < changer.length; k++){

            minSumDifference += Math.abs(changer[k]-constant[k]);
            sortChanger[k] = changer[k];

        }

        Arrays.sort(sortChanger);

        long sum = minSumDifference;

        for(int k = 0; k < changer.length; k++){

            long sumDifference = sum - Math.abs(changer[k] - constant[k]);;
            sumDifference += binarySearch(sortChanger, constant[k]);

            if(sumDifference < minSumDifference)
                minSumDifference = sumDifference;
        }

        return (int)(minSumDifference % MOD);
    }
    private long binarySearch(int[] sortChanger, long target){
        int start = 0;
        int end = sortChanger.length-1;

        while(start<=end){
            int mid = (start + end) / 2;

            if(sortChanger[mid] == target)
                return 0;
            else if(sortChanger[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        long left = Long.MAX_VALUE;
        long right = Long.MAX_VALUE;

        if(start < sortChanger.length)
            left = Math.abs(target - sortChanger[start]);

        if(end >= 0)
            right = Math.abs(sortChanger[end] - target);

        if(left<right)
            return left;

        return right;
    }
}
