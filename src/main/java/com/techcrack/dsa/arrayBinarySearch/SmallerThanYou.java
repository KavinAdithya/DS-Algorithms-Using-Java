package com.techcrack.dsa.arrayBinarySearch;

import java.util.Arrays;

public class SmallerThanYou {
    /*
     *Here the array has been given and we needed to find how many numbers are lesser than current
     *
     */

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int start=0;
        int[] ans=new int[nums.length];
        int pointer=start+1;
        //Counting how many numbers are lesser than current number
        while(start<nums.length){
            if(nums[start]>nums[pointer])
                ans[start]++;
            pointer++;
            if(pointer==nums.length){
                start++;
                pointer=0;
            }
        }
        return ans;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buckets=new int[102];
        int [] res=new int[nums.length];

        //store frequency of each element
        for(int i=0;i<nums.length;i++){
            buckets[nums[i]]++;
        }
        System.out.println(Arrays.toString(buckets)+ "pp");
        //Count smaller number than each element
        for(int i=1;i<buckets.length;i++){
            buckets[i]+=buckets[i-1];
        }
        System.out.println(Arrays.toString(buckets));
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                res[i]=0;
            }else{
                res[i]=buckets[nums[i]-1];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
