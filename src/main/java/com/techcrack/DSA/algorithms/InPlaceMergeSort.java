package com.techcrack.DSA.algorithms;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void sort(int[] array, int start, int end) {
        if (start == end)
            return;

        int mid = (start + end) / 2;

        sort(array, 0, mid);
        sort(array, mid + 1, end);
        mergeSort(array, start, mid, end);
    }

    public static void mergeSort(int[] array, int start, int mid, int end) {
        int fLength = mid - start + 1;
        int sLength = end - mid;

        int[] first = new int[fLength];
        int[] second = new int[sLength];

        for (int i = 0; i < fLength; i++)
            first[i] = array[start + i];

        for (int i = 0; i < sLength; i++)
            second[i] = array[mid + 1 + i];

        int i = 0;
        int j = 0;
        int k = start;

        while (i < fLength && j < sLength) {
            if (first[i] < second[j])
                array[k] = first[i++];
            else
                array[k] = second[j++];
            k++;
        }

        while (i < fLength)
            array[k++] = first[i++];

        while (j < sLength)
            array[k++] = second[j++];

    }


    public static void main(String[] args) {
        int[] array = {0, 9, 1, 8, 2, 7, 3, 6, 4, 5};

        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
