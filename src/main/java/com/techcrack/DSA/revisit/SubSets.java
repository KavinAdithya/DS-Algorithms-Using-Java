package com.techcrack.dsa.revisit;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        int[] arr = {3, 5, 7};

        arraySubsets("", arr, 0);

        subsets.sort(Comparator.comparingInt(String::length));

        for (String p : subsets)
            System.out.println(p);
    }
}
