package com.techcrack.DSA.Sorting;

class SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int  i = 0;
        
        while (i < length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] == nums[correctIndex])
                i++;
            else
                swap(nums, i, correctIndex);
        }

        for (int j = 0; j < length; j++) {
            if ( j + 1 != nums[j])
                return new int[]{nums[j], j + 1};
        }

        return null;
    }

    public void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }
}