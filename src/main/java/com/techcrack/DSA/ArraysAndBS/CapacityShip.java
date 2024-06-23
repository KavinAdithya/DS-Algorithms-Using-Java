package com.techcrack.DSA.ArraysAndBS;

public class CapacityShip {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for(int weight : weights){
            if(weight > start)
                start = weight;
            end += weight;
        }

        while(start < end){
            int mid = (start + end) / 2;
            int day = countDays(weights, mid);

            if(day <= days)
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }

    private int countDays(int[] weights, int maximumWeight){
        int count = 1;
        int sumOfWeights = 0;

        for(int weight : weights){
            sumOfWeights += weight;

            if(sumOfWeights > maximumWeight){
                count++;
                sumOfWeights = weight;
            }
        }

        return count;
    }
}
