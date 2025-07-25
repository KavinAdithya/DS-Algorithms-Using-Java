package com.techcrack.dsa.sorting;

class SortArrayParity {
    public int[] sortArrayByParity(int[] nums) {
       int i = 0;
       int j = nums.length - 1;

       while (i < j) {
            while (i < j && nums[i] % 2 == 0)
                i++;
            while (i < j && nums[j] % 2 != 0)
                j--;
            
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
       }

       return nums;

    }
}