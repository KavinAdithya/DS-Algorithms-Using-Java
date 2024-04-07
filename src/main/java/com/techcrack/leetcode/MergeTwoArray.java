package com.techcrack.leetcode;

import java.util.Arrays;

public class MergeTwoArray {
    public int[] mergeOurAnswer(int[] nums1, int m, int[] nums2, int n) {
        int length=nums1.length-1;
        n--;
        m--;
        while(n!=-1){
            if((m!=-1)&&nums1[m]>nums2[n]){
                nums1[length]=nums1[m];
                m--;
            }
            else{
                nums1[length]=nums2[n];
                n--;
            }
            length--;
        }

        return nums1;
    }
    public int[] mergeLearnAnswer(int[] nums,int m,int[] nums1,int n){
        if (n >= 0) System.arraycopy(nums1, 0, nums, 0 + m, n);
        Arrays.sort(nums);
        for(int nn:nums){
            System.out.println(nn);
        }
        return nums;
    }

}
