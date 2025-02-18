package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] array = {5, -2, 3, 15, 4};
        cyclicSort(array);

        System.out.println(Arrays.toString(array));
    }

    // Cyclic sort
    // It checks whether the number is correct indices where array in range of 1 - n
    static void cyclicSort(int[] array) {
        // length of the array
        int length = array.length;

        int i = 0;
        // Comparing and Swapping n times
        while (i < length) {
            // Checking the value are at right index
            if (array[i] - 1 < 0 || array[i] > length || array[i] - 1 == i)
                i++;
            else
                swap(array, i, array[i] - 1);
        }

    }

    // Swapping elements
    static void swap(int[] array, int first, int last){
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }


}
