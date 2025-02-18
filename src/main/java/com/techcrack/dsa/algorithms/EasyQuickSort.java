package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class EasyQuickSort {
    static void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(array, start, end);
        sort(array, start, pivotIndex - 1);
        sort(array, pivotIndex + 1, end);
    }

    static int partition(int[] array, int start, int end) {
        int pivot = array[end];

        int pointer = start;

        for (int i = start; i < end + 1; i++) {
            if (array[i] < pivot) {
                if (i != pointer)
                    swap(array, i, pointer);
                pointer++;
            }
        }

        swap(array, pointer, end);
        return pointer;
    }

    static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to]  = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}