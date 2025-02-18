package com.techcrack.dsa.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RelativeSortArray {
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int arr : arr1) 
            frequency.put(arr, frequency.getOrDefault(arr, 0) + 1);
        
        int index = 0;

        for (int arr : arr2) {
            int count = frequency.get(arr);

            while (count > 0) {
                arr1[index] = arr;
                index++;
                count--;
            }

            frequency.remove(arr);
        }

        int[] array = new int[arr1.length - index];

        int i = 0;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int count = entry.getValue();

            while (count > 0) {
                array[i] = entry.getKey();
                i++;
                count--;
            }
        }

        Arrays.sort(array);

        for (i = index; i < arr1.length; i++)
            arr1[i] = array[i - index];

        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max  = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int arr : arr1) {
            if (arr > max)
                max = arr;
            if (arr < min)
                min = arr;
        }

        int[] countArray = new int[max - min + 1];

        for (int arr : arr1)
            countArray[arr - min]++;

        int index = 0;

        for (int arr : arr2) {
            while (countArray[arr - min] > 0) {
                arr1[index] = arr;
                index++;
                countArray[arr - min]--;
            }
        }

        if (index == arr1.length)
            return arr1;

        for (int i = min; i < max + 1; i++) {
            while (countArray[i - min] > 0) {
                arr1[index] = i;
                index++;
                countArray[i - min]--;
            }
        }

        return arr1;
    }
}