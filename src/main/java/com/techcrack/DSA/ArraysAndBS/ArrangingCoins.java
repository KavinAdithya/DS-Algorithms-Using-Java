package com.techcrack.DSA.ArraysAndBS;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long m=n;
        long start=1;
        long end=n;

        while(start<=end){
            long mid=(start+end)/2;

            long sumOfMid=(mid*(mid+1))/2;

            if(sumOfMid==m)
                return (int)mid;
            else if(sumOfMid>m)
                end=mid-1;
            else
                start=mid+1;
        }

        return (int)end;
    }
}
