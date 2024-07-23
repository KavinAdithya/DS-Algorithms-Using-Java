package com.techcrack.DSA.Sorting;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int i = 0;

        while(i < length) {
            if(nums[i] >= length || nums[i]  == i)
                i++;
            else{
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        for(int j = 0; j < length; j++)
            if(j != nums[j])
                return j;

        return nums.length;
    }

    public int missingNumber1(int[] nums) {
        int[] hashTable = new int[nums.length];

        for(int num : nums)
            if(num < nums.length)
                hashTable[num]++;


        for(int i = 0; i < nums.length; i++)
            if(hashTable[i] != 1)
                return i;
        return nums.length;
    }

    public int missingNumber3(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end){
            int mid = (start + end) / 2;

            int smallerNumbers = countSmallerNumbers(nums, mid);
            if(smallerNumbers == mid + 1)
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    public int countSmallerNumbers(int[] nums, int target) {
        int count = 0;

        for (int num : nums)
            if (num <= target)
                count++;

        return count;
    }
}
