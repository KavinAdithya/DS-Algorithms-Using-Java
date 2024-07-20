package com.techcrack.DSA.ArraysAndBS;

import java.util.*;
public class ThreeSum {

    //Brute Force O(n*3)
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        int length = nums.length;

        for(int k = 0; k < length - 2; k++){
            for(int d = k + 1; d < length - 1; d++){
                for(int v = d + 1; v < length; v++){
                    if(nums[k] + nums[d] + nums[v] == 0){
                        List<Integer> list1 = Arrays.asList(nums[k], nums[d], nums[v]);
                        Collections.sort(list1);
                        set.add(list1);
                    }
                }
            }
        }

        //  System.out.println(set + " \n" + list);

        return new ArrayList<>(set);
    }


    //Optimized two pointer and sorting solution

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        int length = nums.length;

        for(int k = 0; k < length; k++){

            if(k > 0 && nums[k] == nums[k - 1])
                continue;

            int left = k + 1;
            int right = length - 1;

            while(left < right){
                int sum = nums[k] + nums[left] + nums[right];

                if(sum == 0){
                    list.add(Arrays.asList(nums[k], nums[left++], nums[right]));
                    while(left < right && nums[left] == nums[left - 1])
                        left++;
                }
                else if(sum < 0)
                    left++;
                else
                    right--;
            }
        }

        return list;
    }
}
