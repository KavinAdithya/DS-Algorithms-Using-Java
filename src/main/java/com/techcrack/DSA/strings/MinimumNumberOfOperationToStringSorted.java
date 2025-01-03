package com.techcrack.DSA.strings;

import java.util.Arrays;

public class MinimumNumberOfOperationToStringSorted {

    static void reverseSuffix(char[] arr, int i) {
        int start = i;
        int end = arr.length - 1;

        while (start < end) {
            swap(arr, start, end);

            start++;
            end--;
        }
    }

    static int findIndexI(char[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i] >= arr[i - 1])
            i--;

        return i;
    }

    static int findIndexJ(char[] arr, int i) {
        int j = i;

        while (j < arr.length && arr[j] < arr[i - 1])
            j++;
        return --j;
    }

    static int countOperation(String s) {
        final int MOD = 1_000_000_007;
        char[] curS = s.toCharArray();
        char[] sortedS = s.toCharArray();
        int count = 0;
        Arrays.sort(sortedS);

        while (! Arrays.equals(curS, sortedS)) {
            int i = findIndexI(curS);
            int j = findIndexJ(curS, i);

            swap(curS, i - 1, j);
            reverseSuffix(curS, i);
            count++;

            count = count % MOD;
        }

        return count;
    }

    static void swap(char[] arr, int src, int des) {
        char temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }

    public static void main(String[] args) {
        String s = "aabaa";

        System.out.println("Number of Operations required to sort the " + s + " is " + countOperation(s));
    }

}
