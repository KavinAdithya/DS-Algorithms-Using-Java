package com.techcrack.dsa.revisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SubSets {
    private final static List<String> subsets = new ArrayList<>();

    public static void arraySubsets(String processed, int[] arr, int index) {
        if (arr.length == index) {
            if (! processed.isEmpty())
                subsets.add(processed);
            return;
        }

        arraySubsets(processed + " " + arr[index], arr, index + 1);
        arraySubsets(processed, arr, index + 1);
    }

    public static void setSubsets(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            int size = outer.size();

            int start = 0;

            if (i > 0 && arr[i] == arr[i - 1])
                start = size / 2;
            for (int j = start; j < size; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));

                inner.add(arr[i]);

                outer.add(inner);

            }

            System.out.println(outer);
        }

        System.out.println();
    }

    public static void permutation(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        int end = processed.length() + 1;
        char ch = unprocessed.charAt(0);

        for (int i = 0; i < end; i++) {
            String curProcessed = processed.substring(0, i) + ch + processed.substring(i);
            permutation(curProcessed, unprocessed.substring(1));
        }


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};

        Arrays.sort(arr);

//        setSubsets(arr);
        String p = "abc";

        permutation("", p);
//        arraySubsets("", arr, 0);
//
//        subsets.sort(Comparator.comparingInt(String::length));

//        for (String p : subsets)
//            System.out.println(p);
    }
}
