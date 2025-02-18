package com.techcrack.dsa.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    static void sortUsingArray(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int arr : array) {
            if (arr > max)
                max = arr;
        }

        int[] frequency = new int[max + 1];

        for (int arr : array)
            frequency[arr]++;

        int k = 0;
        for (int i = 0; i < max + 1; i++) {
            int count = frequency[i];

            while (count > 0) {
                array[k] = i;
                k++;
                count--;
            }
        }
    }

    static void sortUsingHashMap(int[] array) {
        if (array == null || array.length == 0)
                return;

        Map<Integer, Integer> countMap = new HashMap<>();

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        for (int arr : array)
            countMap.put(arr, countMap.getOrDefault(arr, 0) + 1);

        int index = 0;

        for (int i = min; i < max + 1; i++) {
            int count = countMap.getOrDefault(i, 0);

            while (count > 0) {
                array[index] = i;
                index++;
                count--;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {4, 1, 2, 7, 6, 1, 2, 3, 4};
        sortUsingHashMap(array);

        System.out.println(Arrays.toString(array));
    }
}
