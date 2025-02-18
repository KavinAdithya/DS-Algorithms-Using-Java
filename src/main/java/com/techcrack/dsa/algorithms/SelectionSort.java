package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class SelectionSort {

    // Driver method for controlling execution flow
    public static void main(String[] args) {
        int[] array = {-1, -1 ,34, -2};
        // Invoking selection sort method
        selectionSort(array);

        // Printing Array
        System.out.println(Arrays.toString(array));
    }

    // Sorting of array using selection sort
    // @Param array is elements which needed to sort it
    static void selectionSort(int[] array) {
        int  length = array.length;

        // Iterating the n - 1 times to find the maximum elements for n - 1 time
        for(int i = 0; i < length - 1; i++){
            int last = length - i - 1;

            // Finding the Maximum index
            int maxIndex = findMaxIndex(array, last);

            // Swapping the maximum Index
            swapIndex(array, last, maxIndex);
        }
    }

    // Finding maximum Index
    // @Return maximum element index
    static int findMaxIndex(int[] array, int end) {
        int maxIndex = 0;

        // comparing each element to find the maximum element in a range
        for(int i = 0; i <= end; i++)

            // Reassign the maxIndex
            if(array[i] > array[maxIndex])
                maxIndex = i;

        return maxIndex;
    }

    // swapping the elements in an array
    static void swapIndex(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
