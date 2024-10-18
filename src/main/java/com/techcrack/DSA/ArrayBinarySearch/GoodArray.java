package com.techcrack.DSA.ArrayBinarySearch;

public class GoodArray {
    public boolean isGoodArray(int[] nums) {
        int answer = nums[0];

        int start = 1;

        while(start < nums.length){
            answer = findGcd(answer, nums[start]);
            start++;
        }

        return answer == 1;
    }

    private int findGcd(int a, int b){
        if(a == 0)
            return b;
        return findGcd(b % a, a);
    }
}
