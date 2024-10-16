package com.techcrack.DSA.Algorithms;

import java.util.Arrays;

public class QuickSort {
    static void sort(int[] array, int low, int high) {

        if (low >= high)
            return;

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = array[mid];

        while (start <= end) {
            while (array[start] < pivot)
                start++;
            while (array[end] > pivot)
                end--;

            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }

        sort(array, low, end);
        sort(array, start, high);
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
