package com.techcrack.dsa.recursion.practise;

public class BinarySearch {
    static int search(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (target == arr[mid])
            return mid;

        if (target < arr[mid])
            return search(arr, target, start, mid - 1);
        return search(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 9, 10, 90};
        int target = 9;

        System.out.println(search(arr, target, 0, arr.length - 1));
    }
}
