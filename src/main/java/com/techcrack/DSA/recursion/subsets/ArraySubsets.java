package com.techcrack.DSA.recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
    static List<List<Integer>> findSubsets(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int a : arr) {
            int n = outer.size();

            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(a);

                outer.add(internal);
            }
        }
        return outer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        for (List<Integer> list : findSubsets(arr)) {
            System.out.println(list);
        }
    }
}
