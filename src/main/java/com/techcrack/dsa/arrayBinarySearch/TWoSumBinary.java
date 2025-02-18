package com.techcrack.dsa.arrayBinarySearch;

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
    public int[] twoSum1(int[] numbers,int target){
        int start=0;
        int end=numbers.length-1;

        while(start<end){
            int x=numbers[start]+numbers[end];
            if(x==target)
                return new int[]{++start,++end};
            int mid=(start+end)/2;
            if(x>target)
                end=(numbers[start]+numbers[mid])>=target?mid:end-1;
            else
                start=(numbers[end]+numbers[mid])>target?start+1:mid;
        }

        return new int[]{0,0};
    }
}
