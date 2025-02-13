package com.techcrack.DSA.recursion.practise;

import java.util.Arrays;



public interface MaximumAndMinimum {
    int operation(int a, int b);

    static int[] findBoundaries(int[] arr, int index, int minIndex, int maxIndex) {
        if (arr == null || arr.length == 0)
            return arr;

        if (arr.length == index)
            return new int[]{arr[minIndex], arr[maxIndex]};

        if (arr[minIndex] > arr[index])
            minIndex = index;

        if (arr[maxIndex] < arr[index])
            maxIndex = index;

        return findBoundaries(arr, index + 1, minIndex, maxIndex);
    }

    static int findMin(int[] arr, int index) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length - 1 == index)
            return arr[index];

        return Math.min(arr[index], findMin(arr, index + 1));
    }

    static void main(String[] args) {
        int[] arr = {91, -1, 89, 56, 2, -12, 1889};

        System.out.println(Arrays.toString(findBoundaries(arr, 1 , 0, 0)));

        System.out.println(findMin(arr, 0));

        MaximumAndMinimum min = Math::min;
        MaximumAndMinimum max = Math::max;

        System.out.println(findMaxOrMin(arr, 0, min));
        System.out.println(findMaxOrMin(arr, 0, max));

    }

    static int findMax(int[] arr, int index) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length - 1 == index)
            return arr[index];

        return Math.max(arr[index], findMax(arr, index + 1));
    }

    static int findMaxOrMin(int[] arr, int index, MaximumAndMinimum maximumAndMinimum) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length - 1 == index)
            return arr[index];

        return maximumAndMinimum.operation(arr[index], findMaxOrMin(arr, index + 1, maximumAndMinimum));
    }
}
