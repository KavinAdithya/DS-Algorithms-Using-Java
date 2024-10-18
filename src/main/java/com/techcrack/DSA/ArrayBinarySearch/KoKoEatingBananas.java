package com.techcrack.DSA.ArrayBinarySearch;

public class KoKoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {


        int maxValue = Integer.MIN_VALUE;
        for(int pile : piles){
            if(pile > maxValue)
                maxValue = pile;
        }

        return binarySearch(piles,h,maxValue);
    }

    private int binarySearch(int[] piles,int hour,int maxValue){
        int start = 1;
        int end = maxValue;

        while(start <= end){
            int mid = (start + end) / 2;
            long hourRequired = findHourRequired(piles,mid);
            if(hourRequired > hour)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }


    private long findHourRequired(int[] piles ,int divider){
        long hourCounter = 0;
        for(int pile : piles)
            hourCounter += (pile + divider -1 ) / divider;

        return hourCounter;
    }

}
