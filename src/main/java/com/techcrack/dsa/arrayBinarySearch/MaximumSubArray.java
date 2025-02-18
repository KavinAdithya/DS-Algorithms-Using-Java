package com.techcrack.dsa.arrayBinarySearch;

public class MaximumSubArray {

    //Given  array we needed to find the maximum sub array

    public int maxSubArray(int[] nums) {

        int n=nums.length;
        int max=0;
        for(int k=1;k<=n;k++){
            max=findGap(nums,max,k);
        }
        return max;
    }

    //Gap Manager
    private int findGap(int[] nums,int max,int gap){

        for(int k=0;k<nums.length;k++){
            int m=sum(nums,k,gap);
            if(m>max)
                max=m;
            ///.out.println("Start "+k+" end "+(k+gap)+" sum "+m+" gap "+gap);
        }

        return max;
    }

    //finding the sum
    private int sum(int[] nums,int start,int gap){
        int sum=0;
        gap+=start;
        while(start<gap&&start<nums.length){
            sum+=nums[start];
            start++;
        }
        return sum;
    }
}
