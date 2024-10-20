package com.techcrack.DSA.Sorting;

import java.util.HashSet;
import java.util.Set;

class ThirdLargestValue {
    public int thirdMax(int[] nums) {
        Set<Integer> distinctNum = new HashSet<>();

        for (int num : nums)
            distinctNum.add(num);
        
        int min = Integer.MIN_VALUE;
        int first = min;
        int second = min;
        int third = min;

        for (Integer num : distinctNum) {
            if (num > first) 
                first = num;
        }

        for (Integer num : distinctNum) {
            if (num != first && num > second) 
                second = num;
        }

        for (Integer num : distinctNum) {
            if (num != first && num != second && num > third) 
                third = num;
        }

        if (distinctNum.size() < 3)
            return Math.max(second, first);

        return third;
    }

    public int thirdMax1(int[] nums) {

        long min = Integer.MIN_VALUE;
        min--;
        long first = min;
        long second = min;
        long third = min;
        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }

            if (num != first && num > second) {
                third = second;
                second = num;
            }

            if (num != first && num != second && num > third)
                third = num;
        }


        return third != min ? (int) third : (int) first;
    }
}