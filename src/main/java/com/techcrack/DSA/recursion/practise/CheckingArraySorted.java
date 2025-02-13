package com.techcrack.DSA.recursion.practise;

public class CheckingArraySorted {
    static  boolean isSorted(int[] arr, int index) {
        return index >= arr.length || (arr[index - 1] <= arr[index] && isSorted(arr, index + 1));
    }

    public static void main(String[] args) {
//        int[] arr = {1, -1};
//
//        System.out.println(isSorted(arr, 1));

        System.out.println(Integer.parseInt("01"));
    }
}
