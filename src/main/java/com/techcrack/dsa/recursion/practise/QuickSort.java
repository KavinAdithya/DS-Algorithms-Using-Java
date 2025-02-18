package com.techcrack.dsa.recursion.practise;

import java.util.Arrays;

public class QuickSort {
    static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        int start = low;
        int end = high;

        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        sort(arr, low, end);
        sort(arr, start, high);
    }

    public static void main(String[] args) {
        int[] arr = {89, 5, 3, 1, 2 , -1};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
