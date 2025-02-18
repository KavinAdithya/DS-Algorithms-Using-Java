package com.techcrack.dsa.arrayBinarySearch;

import java.util.*;

public class TwoSumVisit {
    public int[] twoSum0(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int k = 0; k < nums.length; k++)
            numMap.put(nums[k],k);


        for(int k = 0; k < nums.length; k++){
            if(numMap.containsKey(target - nums[k]) && numMap.get(target - nums[k]) != k)
                return new int[]{numMap.get(target - nums[k]), k};
        }

        return null;
    }

    //Optimized Mapping
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int k = 0; k < nums.length; k++){
            if(map.containsKey(target - nums[k]))
                return new int[]{map.get(target - nums[k]), k};
            map.put(nums[k], k);
        }

        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        for(int k = 1; k < nums.length; k++){
            for(int d = k; d < nums.length; d++){
                if(nums[d - k] + nums[d] == target)
                    return new int[]{d, d - k};
            }

        }
        return null;
    }

}
