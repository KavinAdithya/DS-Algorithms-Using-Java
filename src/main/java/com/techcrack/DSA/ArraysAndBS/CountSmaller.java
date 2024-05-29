
package com.techcrack.DSA.ArraysAndBS;

import java.util.*;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> number = new ArrayList<Integer>();

        for(int num : nums)
            number.add(num);

        Collections.sort(number);

        for(int num : nums){
            int index =  binarySearch(number, num);

            answer.add(index);
            number.remove(index);
        }

        return answer;
    }

    private int binarySearch(List<Integer> number, int target){

        int start = 0;
        int end = number.size() - 1;
        int index = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int value = number.get(mid);

            if(value == target){
                end = mid - 1;
                index = mid;
            }
            else if(value > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return index;
    }

    // Brute Force
    // public List<Integer> countSmaller(int[] nums) {
    //    List<Integer> result = new ArrayList<>();

    //    for(int k = 0; k < nums.length; k++){
    //         int count = 0;

    //         for(int d = k + 1; d < nums.length; d++){
    //             if(nums[k] > nums[d])
    //                 count++;
    //         }

    //         result.add(count);
    //    } 

    //    return result;
    // }
}