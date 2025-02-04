package com.techcrack.DSA.recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
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

    static List<List<Integer>> findSubsetsWithoutDuplicate(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(arr);

        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;

            if (i > 0 && arr[i - 1] == arr[i])
                start = end;
            end = outer.size();

            for (int j = start; j < end; j++) {
                List<Integer> inter = new ArrayList<>(outer.get(j));

                inter.add(arr[i]);

                outer.add(inter);
            }
        }

        return outer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        for (List<Integer> list : findSubsetsWithoutDuplicate(arr)) {
            System.out.println(list);
        }
    }
}
