package com.techcrack.DSA.sorting;

import java.util.Arrays;

class LargestNumber {
    public String largestNumber(int[] nums) {
        
        if (nums == null || nums.length < 1)
            return "";

        String[] numStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            numStr[i] = String.valueOf(nums[i]);
        
        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
        if (numStr[0].equals("0"))
            return "0";

        StringBuilder largestNum = new StringBuilder();

        for (String num : numStr)
            largestNum.append(num);
        
        return largestNum.toString();
    }
}