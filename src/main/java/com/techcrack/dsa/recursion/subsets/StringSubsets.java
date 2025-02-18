package com.techcrack.dsa.recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class StringSubsets {
    static void subsets(List<String> subsets, String processes, String unprocessed) {
        if (unprocessed.isEmpty()) {
            if (! processes.isEmpty())
                subsets.add(processes);
            System.out.println(processes);
            return;
        }

        char ch = unprocessed.charAt(0);

        unprocessed = unprocessed.substring(1);

//        subsets(subsets, processes + " " + ch, unprocessed);
        subsets(subsets, processes, unprocessed);
        subsets(subsets, processes + " " + (int) ch, unprocessed);
    }

    public static void main(String[] args) {
        List<String> subsets = new ArrayList<>();

        String s = "abc";

        subsets(subsets, "", s);

        subsets.sort(String :: compareTo);
//        System.out.println(subsets);
    }
}
