package com.techcrack.DSA.Sorting;

import java.util.Arrays;

class SquareSortedArray {
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }


    public static int[] sortedSquares(int[] nums) {

        if (nums.length == 0)
            return nums;

        int midIndex = binarySearch(nums);

        int left = midIndex - 1;
        int right = midIndex;
        int length = nums.length;

        int[] square = new int[length];
        int k = 0;

        while (left >= 0 && right < length) {

            if (nums[left] * - 1 <  nums[right]) {
                square[k++] = nums[left] * nums[left];
                left--;
            }
            else {
                square[k++] = nums[right] * nums[right];
                right++;
            }
        }

        while (left >= 0) {
            square[k++] = nums[left] * nums[left];
            left--;
        }

        while (right < length) {
            square[k++] = nums[right] * nums[right];
            right++;
        }

        return square;
    }

    private static int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > 0)
                end = mid;
            else
                start = mid + 1;
        }

        return nums[end] >= 0 ? end : nums.length;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};


        System.out.println(Arrays.toString(sortedSquares(array)));
    }
}