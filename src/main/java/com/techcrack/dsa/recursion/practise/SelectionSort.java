package com.techcrack.dsa.recursion.practise;

import java.util.Arrays;

public class SelectionSort {
    static void sort(int[] arr, int maxIndex, int row, int col) {
        if (row == 1 || arr.length == 0) return;

        if (row == col) {
            swap(arr, maxIndex, row - 1);
            sort(arr, 0, row - 1, 1);
            return;
        }

        if (arr[maxIndex] < arr[col])
            maxIndex = col;

        sort(arr, maxIndex, row, col + 1);
    }

    static void swap(int[] arr, int src, int des) {
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {};

        sort(arr, 0, arr.length, 1);

        System.out.println(Arrays.toString(arr));
    }
}
