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
}