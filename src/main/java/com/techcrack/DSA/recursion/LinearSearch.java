package com.techcrack.DSA.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    static int findIndex(int[] arr, int target, int index) {
        return index >= arr.length ? -1 : target == arr[index] ? index : findIndex(arr, target, index + 1);
    }

    static List<Integer> findAllIndex(int[] arr, int index, int target) {
        if (index >= arr.length)
            return new ArrayList<>();

        List<Integer> list = findAllIndex(arr, index + 1, target);

        if (target == arr[index])
            list.add(0, index);

        return list;
    }

    static List<Integer> findAllIndex1(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();

        if (index == arr.length)
            return list;

        if (target == arr[index])
            list.add(index);

        List<Integer> ans = findAllIndex1(arr, target, index + 1);
        list.addAll(ans);

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {102, 13, 27, 102, 19, 102};
//        System.out.println(findIndex(arr, 19, 0));

        List<Integer> ans = findAllIndex1(arr, 102, 0);
        System.out.println(ans);
    }
}
