package com.techcrack.dsa.recursion.sorting;

import java.util.Arrays;

public class Sorting {

    static void bubbleSort(int[] arr, int row, int col) {
        if (row == 0) return;

        if (row == col) {
            bubbleSort(arr, row - 1, 1);
            return;
        }

        if (arr[col - 1] > arr[col])
            swap(arr, col - 1, col);

        bubbleSort(arr, row, col + 1);
    }

    static void swap(int[] arr, int src, int des) {
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    static void insertionSort(int[] arr, int row) {
        if (row == arr.length) return;

        int pivot = arr[row];

        int i = row;

        while (i > 0) {
            if (arr[i - 1] < pivot) break;

            arr[i] = arr[i - 1];
            i--;
        }

        arr[i] = pivot;

        insertionSort(arr, row + 1);
    }

    public static void main(String[] args) {
        int[] arr = {89, 2, 6, -1, 78};

//        bubbleSort(arr, arr.length, 1);
        insertionSort(arr, 1);
        
        System.out.println(Arrays.toString(arr));
    }
}
