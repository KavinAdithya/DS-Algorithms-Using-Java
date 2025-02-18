package com.techcrack.dsa.arrayBinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelfMinimum {

    //Brute Force
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int k = 0; k < nums.length; k++){
            int count = 0;
            for(int d = k + 1; d < nums.length; d++){
                if(nums[k] > nums[d])
                    count++;
            }
            result.add(count);
        }

        return result;
    }

    //Arrays and Binary Search
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> sortedNums = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums)
            sortedNums.add(num);

        Collections.sort(sortedNums);

        for (int num : nums) {
            int index = findElement(sortedNums, num);
            result.add(index);
            sortedNums.remove(index);
        }

        return result;
    }

    private int findElement(List<Integer> sortedNums, int target){
        int start = 0;
        int end = sortedNums.size() - 1;
        int index = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            int value = sortedNums.get(mid);
            if(value == target){
                index = mid;
                end = mid - 1;
            }
            else if(value < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return index;
    }
}
