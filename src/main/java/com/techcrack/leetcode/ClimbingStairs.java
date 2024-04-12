package com.techcrack.leetcode;

public class ClimbingStairs {
    //Finding fibononci series
    public int climbStairs(int n) {
        int a=0;
        int b=1;
        for(int k=0;k<n;k++){
            int temp=a;
            a=b;
            b=temp+b;
        }

        return b;
    }
}
