package com.techcrack.DSA.Arrays;

public class TWoSumBinary {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;


        while(start<end){
            int x=numbers[start]+numbers[end];
            if(x==target)
                return new int[]{++start,++end};
            else if(x>target)
                end--;
            else
                start++;
        }


        return new int[]{0,0};
    }
}
