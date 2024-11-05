package com.techcrack.DSA.Algorithms;

import java.util.Arrays;

class QuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, nums.length - k);   
    }

    private static int sort(int[] arr, int low, int high, int k) {
        if (low == high)
            return arr[low];
            
        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex)
            return arr[pivotIndex];
        else if ( k > pivotIndex)
            return sort(arr, pivotIndex + 1, high, k);
        else
            return sort(arr, low, pivotIndex - 1, k);
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lowIndex = low ;

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] <= pivot) {
                lowIndex++;
                if (i != lowIndex)
                    swap(arr, i, lowIndex);
            }
        }

        swap(arr, low, lowIndex);
        return lowIndex;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int mid = partition(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);

    }

    private static int partition1(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low;

        for (int i = j; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
        }

        swap(arr, j, high);
        return j;
    }

    private static void swap(int[] arr, int src, int des) {
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};

//        System.out.println(partition(arr, 0, arr.length - 1));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}