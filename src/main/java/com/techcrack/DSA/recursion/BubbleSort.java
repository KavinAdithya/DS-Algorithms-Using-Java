package com.techcrack.DSA.recursion;

import java.util.Arrays;

public class BubbleSort {

    static void sortArray(int[] arr, int row, int col)  {
        if (row == 0) return;

        if (row == col) {
            sortArray(arr, row - 1, 1);
            return;
        }

        if (arr[col - 1] > arr[col])
            swap(arr, col - 1, col);

        sortArray(arr, row, col + 1);
    }

    static void swap(int[] arr, int src, int des) {
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 4, 1};
        sortArray(arr, 5, 1);

        System.out.println(Arrays.toString(arr));
    }
}
