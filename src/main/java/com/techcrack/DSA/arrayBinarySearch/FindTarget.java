package com.techcrack.DSA.arrayBinarySearch;
import java.util.*;

class FindTarget {
    //Optimized Solution O(n) time complexity
    public List<Integer> targetIndices1(int[] nums, int target) {
        int count = 0;
        int startIndex = 0;

        for(int k = 0; k < nums.length; k++){

            if(nums[k] < target)
                startIndex++;
            else if(nums[k] == target)
                count++;

        }

        List<Integer> list = new ArrayList<Integer>();

        while(count-- > 0)
            list.add(startIndex++);

        return list;
    }

    //O(n log n ) Time complexity
    public List<Integer> targetIndices(int[] nums, int target) {
        mergeSort(nums, 0, nums.length - 1);
        int startIndex = binarySearch(nums, target);

        int[] array = new int[nums.length - startIndex + 1];
        int a = 0;

        while(startIndex < nums.length && nums[startIndex] == target)
            array[a++] = startIndex++;



        List<Integer> list = new ArrayList<Integer>();

        for(int k = 0; k < a; k++)
            list.add(array[k]);

        return list;
    }

    //Dividing
    private void mergeSort(int[] array, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merging(array, start, mid, end);
        }
    }

    //Sorting and merging
    private void merging(int[] array, int start, int mid, int end){
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for(int k = 0; k < leftLength; k++)
            leftArray[k] = array[start + k];

        for(int k = 0; k < rightLength; k++)
            rightArray[k] = array[mid + 1 + k];

        int l = 0, r = 0, k = start;

        while(l < leftLength && r < rightLength){

            if(leftArray[l] <= rightArray[r])
                array[k++] = leftArray[l++];
            else
                array[k++] = rightArray[r++];

        }

        while(l < leftLength)
            array[k++] = leftArray[l++];

        while(r < rightLength)
            array[k++] = rightArray[r++];

    }

    //Binary search
    private int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while(start < end){
            int mid = (start + end) / 2;

            if(array[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}