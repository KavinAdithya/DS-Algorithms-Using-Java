package com.techcrack.DSA.sorting;

import java.util.Arrays;

class HeightChecker {
    public int heightChecker1(int[] heights) {
        int n = heights.length;
        
        int[] dup = new int[n];

        for (int i = 0; i < n; i++) 
            dup[i] = heights[i];
        
        Arrays.sort(dup);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dup[i] != heights[i])
                count++;
        }

        return count;
    }

    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] dup = new int[n];

        for (int i = 0; i < n; i++)
            dup[i] = heights[i];

        sortUsingArray(dup);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dup[i] != heights[i])
                count++;
        }

        return count;
    }
    private void sortUsingArray(int[] array) {
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
}