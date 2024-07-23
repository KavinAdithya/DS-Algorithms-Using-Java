package com.techcrack.DSA.Sorting;

import java.util.ArrayList;
import java.util.List;

public class findMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int length = nums.length;
        int i = 0;

        while(i < length ){
            if(nums[i] - 1 == i || nums[nums[i] - 1] == nums[i])
                i++;
            else
                swap(nums, nums[i] - 1, i);
        }

        for(int j = 0; j < length ; j++)
            if(j + 1!= nums[j])
                list.add(j + 1);

        return list;

    }

    public void swap(int[] array, int first, int last){
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    public int findDisappearedNumbers1(int[] nums) {
        int length = nums.length;

        int i =0;

        while (i < length) {
            if (nums[i] != i + 1){
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                else
                    swap(nums, nums[i] - 1, i);
            }
            else
                i++;
        }

        return 0;
    }
}
