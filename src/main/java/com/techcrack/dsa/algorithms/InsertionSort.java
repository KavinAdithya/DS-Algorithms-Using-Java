package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, -1, 89, 355, 2};
        sort(array);

        System.out.println(Arrays.toString(array));
    }

    // Insertion Sort Algorithm
    // It will compare the previous sorted array
    // Insert it at correct position n - 2 times outer loop runs.
    static void insertionSort(int[] array) {
        // Storing the length of the array
        int length = array.length;

        // Outer loop runs n - 2 time
        for (int i = 0; i < length - 1; i++) {

            // comparing the current value with the previous value until 0 index
            for (int j = i + 1; j > 0; j--) {
                // Comparing previous value.
                // In case if it is greater swap or break it.
                if (array[j] < array[j - 1])
                    swap(array, j, j -1);
                else
                    break;
            }
        }
    }


    static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];

            int index = sortPartial(array, value, i);

            array[index] = value;
        }
    }

    static int sortPartial(int[] array, int value, int end) {
        for (int i = end - 1; i > -1; i--) {
            if (value > array[i])
                return i + 1;
            array[i + 1] = array[i];
        }

        return 0;
    }

    // Swap the two elements based on index
    static void swap(int[] array, int first, int last) {
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }


}
