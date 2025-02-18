package com.techcrack.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesElements {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;

        while (i < length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex])
                swap(nums, i, correctIndex);
            else
                i++;
        }

        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < length; j++) {
            if ( j  + 1 != nums[j])
                list.add(nums[j]);
        }

        return list;
    }

    public void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }
}
