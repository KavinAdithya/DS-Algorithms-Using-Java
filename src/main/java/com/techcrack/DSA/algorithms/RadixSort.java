package com.techcrack.DSA.algorithms;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] arr) {

        if (arr == null || arr.length < 2)
            return;

        int n = arr.length;

        int max = findMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            radixSort(arr, exp, n);
        }
    }

    static void radixSort(int[] arr, int exp, int n) {
        int[] count = new int[10];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            int index = arr[i] / exp % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i] / exp % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    static int findMax(int[] arr) {
        int max = arr[0];

        for (int a : arr) {
            if ( a > max)
                max = a;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5, 12, 45, 890, 67, 23, 4, 67};

        System.out.println("Before Radix Sorting : " +  Arrays.toString(arr));

        sort(arr);

        System.out.println("After  radix Sorting : " + Arrays.toString(arr));
    }

}
