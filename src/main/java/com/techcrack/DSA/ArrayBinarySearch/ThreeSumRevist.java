package com.techcrack.DSA.ArrayBinarySearch;

import java.util.*;
public class ThreeSumRevist {
    //Brute Force
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for(int k = 0; k < nums.length; k++){
            for(int v = k + 1; v < nums.length; v++){
                for(int d = v + 1; d < nums.length; d++){
                    if(nums[k] + nums[v] + nums[d] == 0){
                        List<Integer> listLocal = new ArrayList<>();
                        listLocal.add(nums[k]);
                        listLocal.add(nums[v]);
                        listLocal.add(nums[d]);
                        Collections.sort(listLocal);
                        set.add(listLocal);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> hash = new HashMap<>();

        for(int k = 0; k < nums.length; k++)
            hash.put(nums[k], k);

        for(int k = 0; k < nums.length; k++){
            for(int v = k + 1; v < nums.length; v++){

                int required = - 1 * (nums[k] + nums[v]);

                if(hash.containsKey(required) && v < hash.get(required)){

                    List<Integer> list = new ArrayList<>();
                    list.add(- 1 * (nums[k] + nums[v]));
                    list.add(nums[k]);
                    list.add(nums[v]);

                    Collections.sort(list);
                    set.add(list);
                }
            }
        }

        return new ArrayList<>(set);
    }

    //Optimized Solution
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;

        for(int k = 0; k < length; k++){
            if(k > 0 && nums[k] == nums[k - 1])
                continue;

            int start = k + 1;
            int end = length - 1;

            while(start < end){
                int sum = nums[k] + nums[start] + nums[end];

                if(sum == 0){
                    list.add(Arrays.asList(nums[k], nums[start], nums[end]));
                    start++;

                    while(start < end && nums[start] == nums[start - 1])
                        start++;
                }
                else if(sum > 0)
                    end--;
                else
                    start++;
            }
        }

        return list;
    }
}
