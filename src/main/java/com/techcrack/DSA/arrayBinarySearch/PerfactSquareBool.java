package com.techcrack.DSA.arrayBinarySearch;

public class PerfactSquareBool {
    public boolean isPerfectSquare(int num) {
        long start=1;
        long end=num;

        while(start<=end){
            long mid=(start+end)/2;
            long squareValueMid=mid*mid;
            if(squareValueMid==num)
                return true;
            else if(squareValueMid>num)
                end=mid-1;
            else
                start=mid+1;
        }

        return false;
    }
}
