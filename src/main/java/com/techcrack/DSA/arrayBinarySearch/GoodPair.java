package com.techcrack.DSA.arrayBinarySearch;

public class GoodPair {
    /*
     * Given an array we needed to find how many pairs a good pairs if they
     * nums[i]==nums[j] and i<j
     */

    public int numIdenticalPairs(int[] nums) {
        int start=0;
        int pointer=start+1;
        int result=0;
        //Iterating array and finding the good pairs in an array
        while(start<nums.length-1){
            //if the values are equal then they are good pairs because we are traversing in ascending order
            if(nums[start]==nums[pointer])
                result++;
            pointer++;
            if(pointer==nums.length){
                start++;
                pointer=start+1;
            }
        }
        return result;
    }
}
