package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] array) {

        if (array.length < 2)
            return array;

        int mid = array.length / 2;

        int[] leftArray = sort(Arrays.copyOfRange(array, 0, mid));
        int[] rightArray = sort(Arrays.copyOfRange(array, mid, array.length));

        return mergeArray(leftArray, rightArray);
    }

    public static int[] mergeArray(int[] first, int[] second) {
        int fLength = first.length;
        int sLength = second.length;

        int[] third = new int[fLength + sLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < fLength && j < sLength) {
            if (first[i] < second[j])
                third[k] = first[i++];
            else
                third[k] = second[j++];
            k++;
        }

        while (i < fLength)
            third[k++] = first[i++];

        while (j < sLength)
            third[k++] = second[j++];


        return third;
    }

    public static void main(String[] args) {
        int[] sorted = sort(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 0});

        System.out.println(Arrays.toString(sorted));
    }
}
