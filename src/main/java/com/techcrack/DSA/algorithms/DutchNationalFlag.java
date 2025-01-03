package com.techcrack.DSA.algorithms;

import java.util.Arrays;

public class DutchNationalFlag {
    static void dutchNationalFlag(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length -  1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid , low);
                mid++;
                low++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid , high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int src, int des) {
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 2, 0, 2};
        dutchNationalFlag(arr);

        Arrays.stream(arr)
                .forEach(System.out :: println);
    }
}
