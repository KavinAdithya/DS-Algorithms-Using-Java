package com.techcrack.DSA.recursion;

public class LinearSearch {
    static int findIndex(int[] arr, int target, int index) {
        return index >= arr.length ? -1 : target == arr[index] ? index : findIndex(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {102, 13, 27, 68, 19, 10};
        System.out.println(findIndex(arr, 19, 0));
    }
}
