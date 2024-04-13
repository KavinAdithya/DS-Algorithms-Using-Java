package com.techcrack.leetcode;
import java.util.Arrays;
public class SubMaxArray {

    //Finding the Largest sub array When it is divided into two subbArray
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;

        //Finding the max and min chance of answer
        for(int d:nums){
            start=start>d?start:d;
            end+=d;
        }

        //Binary Search For finding answer
        while(start<end){
            int mid=(start+end)/2;

            int pieces=0;
            int sum=0;
            for(int d:nums){
                if(sum+d>mid){
                    sum=d;
                    ++pieces;
                }
                else
                    sum+=d;
            }
            if(pieces>k)
                start+=mid+1;
            else
                end=mid;
        }
        return start;
    }
}
