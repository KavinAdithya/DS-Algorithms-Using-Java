package com.techcrack.DSA.Arrays;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map=new HashMap<>();
        int d=0;
        for(int k:nums){
            if(map.containsKey(target-k))
                return new int[]{d,map.get(target-k)};
            map.put(k,d);
            d++;
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum1(int[] nums,int target){
        for(int k=1;k<nums.length;k++){
            for(int d=k;d<nums.length;d++){
                if((nums[d-k]+nums[k])==target)
                    return new int[]{d-k,d};
            }
        }
        return new int[]{-1,-1};
    }
}
