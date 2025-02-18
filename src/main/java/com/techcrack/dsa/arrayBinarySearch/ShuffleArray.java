package com.techcrack.dsa.arrayBinarySearch;

import java.util.Arrays;

public class ShuffleArray {
    //Given a array of 2n size {1,2,3,1,2,3} n=3
    //We needed to make this array as {1,1,2,2,3,3}

    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[n*2];
        int m=0;
        for(int k=0;k<n*2;k++){
            ans[k]=nums[m];
            ans[k+1]=nums[m+n];
            k++;
            m++;
        }
        return ans;
    }

    //Using O(1) space complexity
    public int[] array(int[] nums,int n){
        int m=0;
        for(int k=0;k<(n*2);k++){
            nums[k]=(nums[m]%(n*2))+((nums[m]%(n*2)*(n*2)));
            nums[k+1]=(nums[m+1]%(n*2))+((nums[m+n]%(n*2)*(n*2)));
            m++;
            k++;
        }
        System.out.println(Arrays.toString(nums));
        for(int k=0;k<(n*2);k++){
            nums[k]=nums[k]/(n*2);
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
