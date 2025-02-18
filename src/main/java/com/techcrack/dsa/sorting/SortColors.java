package com.techcrack.dsa.sorting;

class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            }
            else if (nums[mid] == 1)
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int source, int destination) {
        int temp = nums[source];
        nums[source] = nums[destination];
        nums[destination] = temp;
    }

    public void sortColors1(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int n : nums) {
            if (n == 0)
                red++;
            else if (n == 1)
                white++;
            else
                blue++;
        }

        int i = 0;

        while (red > 0) {
            nums[i] = 0;
            red--;
            i++;
        }

        while (white > 0) {
            nums[i] = 1;
            white--;
            i++;
        }

        while (blue > 0) {
            nums[i] = 2;
            blue--;
            i++;
        }
    }
}