package com.techcrack.dsa.arrayBinarySearch;

import java.util.HashSet;

public class FirstMissing {
    public int firstMissingPositive1(int[] nums) {
        int length = nums.length;

        for(int k = 1; k < length + 2; k++){
            int flag = 0;

            for(int num : nums){
                if(k == num){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0)
                return k;
        }

        return -1;
    }
    public int firstMissingPositive2(int[] nums) {
        HashSet<Integer> hashing = new HashSet<>();

        for(int num : nums)
            hashing.add(num);

        for(int value = 1; value < nums.length + 2; value++)
            if(!hashing.contains(value))
                return value;

        return -1;
    }


    public int firstMissingPositive(int[] nums) {
        //Cyclic sort
        int start = 0;
        int end = nums.length;

        while(start < end){
            int startValue = nums[start];
            if(startValue - 1 >= 0 && startValue - 1 < end && startValue != nums[startValue - 1]){
                int temp = nums[startValue - 1];
                nums[startValue - 1] = startValue;
                nums[start] = temp;
            }
            else
                start++;
        }

        for(int k = 0; k < end; k++)
            if(k + 1 != nums[k])
                return k + 1;

        return end + 1;
    }
}
