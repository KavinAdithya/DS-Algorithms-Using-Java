package com.techcrack.DSA.Algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] array = {189, 12, 344, 895, -11, 20, -1};
        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }

    // sorting the array using bubble sort algorithm
    static void bubbleSort(int[] array){
        int length = array.length;
        boolean swapped;

        // Outer loop iterating n - 1 element and comparing
        for (int i = 0; i < length - 1; i++){
            swapped = false;

            // inner loop comparing and swapping in case of fails to satisfy condition
            for (int j = 1; j < length - i; j++){

                // comparing two values and swapping on satisfy the condition
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }
}
