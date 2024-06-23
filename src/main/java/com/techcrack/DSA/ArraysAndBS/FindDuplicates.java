package com.techcrack.DSA.ArraysAndBS;

public class FindDuplicates {

    //Binary Search
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length ;

        while(start < end){
            int mid = (start + end) / 2;
            int lesserCount = findLesser(nums,mid);

            if(lesserCount <= mid){
                start = mid + 1;
            }
            else
                end = mid ;
        }

        return end;
    }

    private int findLesser(int[] nums, int larger){
        int count = 0;

        for(int num : nums){
            if(num <= larger)
                count++;
        }

        return count;
    }

    //Hashing
    public int findDuplicate1(int[] nums) {
        int[] result = new int[nums.length + 1];

        for(int num : nums){
            if(result[num] == 1)
                return num;
            result[num]++;
        }

        return -1;
    }

    //Floyd's Cycle
    public int findDuplicate3(int[] num) {
        int start = num[0];
        int end = num[0];

        do{
            start = num[start];
            end = num[num[end]];
        }while(start != end);

        start = num[0];

        while(start != end){
            start = num[start];
            end = num[end];
        }

        return start;
    }

    public int findDuplicate0(int[] nums) {
        int[] result = new int[nums.length + 1];

        for(int num : nums){
            if(result[num] == 1)
                return num;
            result[num]++;
        }

        return -1;
    }

}
