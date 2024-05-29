package com.techcrack.DSA.ArraysAndBS;

public class BadResult {


    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        long start=0;
        long end=n;
        int m=n;
        while(start<=end){
            long mid=(start+end)/2;
            if(isBadVersion((int)mid)){
                m=(int)mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }

        return m;
    }

    private boolean isBadVersion(int mid) {

        return true;
    }
}
