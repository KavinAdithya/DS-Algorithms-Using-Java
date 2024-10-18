package com.techcrack.DSA.ArrayBinarySearch;

public class ShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int eachWeights = 0;
        int totalWeights = 0;

        int start = Integer.MIN_VALUE;

        for(int w : weights){
            if(w > start)
                start = w;
            totalWeights += w;
        }

        int end = totalWeights;

        while(start <= end){

            int mid = (start + end) / 2;

            if(findDays(weights, mid) <= days){
                eachWeights = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;

        }

        return eachWeights;
    }



    private int findDays(int[] weights, int target){
        int value = 0;
        int days = 1;
        for(int w : weights){
            value += w;
            if(value > target){
                days++;
                value = w;
            }
        }
        return days;
    }
}
