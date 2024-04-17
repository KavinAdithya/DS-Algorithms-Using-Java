package com.techcrack.DSA.Arrays;

import java.util.ArrayList;
import java.util.List;
public class TargetArray {
    /*
      *Given an array consisting of values and another array
      * mentioning some address
      * we needed to  create a target array
      * based on index array
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list=new ArrayList<>(nums.length);
        for(int k=0;k<nums.length;k++){
            list.add(index[k],nums[k]);
        }

        int[] ans=new int[nums.length];

        int k=0;
        for(Integer d:list){
            ans[k]=d;
            k++;
        }

        return ans;
    }
}
