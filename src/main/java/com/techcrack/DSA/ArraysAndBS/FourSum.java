package com.techcrack.DSA.ArraysAndBS;

import java.util.*;

public class FourSum {

    //Optimized Solution
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();

        int length = nums.length;
        Arrays.sort(nums);

        for(int k = 0; k < length - 3; k++){

            if(k > 0 && nums[k] == nums[k - 1])
                continue;

            for(int d = k + 1; d < length - 2; d++){
                if(d > k + 1 && nums[d] == nums[d - 1])
                    continue;

                int start = d + 1;
                int end = length - 1;

                while(start < end){
                    long target1 = (long)nums[k] + nums[d] + nums[start] + nums[end];
                    if(target1 == target){
                        list.add(Arrays.asList(nums[k], nums[d], nums[start], nums[end]));
                        start++;

                        while(start < end && nums[start] == nums[start - 1])
                            start++;
                    }
                    else if(target < target1)
                        end--;
                    else
                        start++;
                }
            }
        }

        return list;
    }

    //Brute Force
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        int length = nums.length;

        for(int k = 0; k < length - 3; k++){
            for(int d = k + 1; d < length - 2; d++){
                for(int v = d + 1; v < length - 1; v++){
                    for(int n = v + 1; n < length; n++){
                        if((long)nums[k] + nums[d] + nums[v] + nums[n] == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[k]);
                            list.add(nums[d]);
                            list.add(nums[v]);
                            list.add(nums[n]);

                            Collections.sort(list);

                            set.add(list);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
