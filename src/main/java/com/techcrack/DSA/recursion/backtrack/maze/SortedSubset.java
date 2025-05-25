package com.techcrack.dsa.recursion.backtrack.maze;

import java.util.ArrayList;
import java.util.List;

public class SortedSubset {

    private static List<String> possibleSubsets(String s) {
        List<String> subsets = new ArrayList<>();

        int n = s.length();
        int end = (1 << n);

        for (int i = 1; i < end; ++i) {
            StringBuilder binary = new StringBuilder();

            int num = i;
            while (num > 0) {
                binary.append(num % 2);
                num /= 2;
            }

            StringBuilder subset = new StringBuilder();

            for (int j = 0; j < n && j < binary.length(); ++j) {
                if (binary.charAt(j) == '1') {
                    subset.append(s.charAt(j));
                }
            }

            subsets.add(subset.toString());
        }

        subsets.sort(null);

        return subsets;
    }

    private static List<String> possibleSubsets1(String s) {
        List<String> subsets = new ArrayList<>();

        int n = s.length();
        int end = (1 << n);

        for (int i = 1; i < end; ++i) {

            StringBuilder subset = new StringBuilder();

            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    subset.append(s.charAt(j));
                }
            }

            subsets.add(subset.toString());
        }

        subsets.sort(null);

        return subsets;
    }

    private static String convertIntoString(List<Character> elements) {
        StringBuilder subset = new StringBuilder();

        for (Character ele : elements) {
            subset.append(ele);
        }

        return subset.toString();
    }

    private static void generateSubset(List<String> subsets, List<Character> processed, String unprocessed, int index) {
        if (unprocessed.length() == index) {
            if (! processed.isEmpty()) {
                subsets.add(convertIntoString(processed));
            }
            return;
        }

        // Backtracking
        processed.add(unprocessed.charAt(index));
        generateSubset(subsets, processed, unprocessed, index + 1);
        processed.remove(processed.size() - 1);

        generateSubset(subsets, processed, unprocessed, index + 1);
    }

    private static void generateSubset1(List<String> subsets, StringBuilder processed, String unprocessed, int index) {
        if (unprocessed.length() == index) {
            if (! processed.isEmpty()) {
                subsets.add(processed.toString());
            }
            return;
        }

        // Backtracking
        processed.append(unprocessed.charAt(index));
        generateSubset1(subsets, processed, unprocessed, index + 1);
        processed.deleteCharAt(processed.length() - 1);

        generateSubset1(subsets, processed, unprocessed, index + 1);
    }

    public static List<String> subsetsFindIt(String curStr)  {
        List<String> subsets = new ArrayList<>();

        int n = curStr.length();

        for (int i = 1; i < (1 << n); ++i) {
            StringBuilder curPermutation = new StringBuilder();


            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    curPermutation.append(curStr.charAt(j));
                }
            }

            subsets.add(curPermutation.toString());
        }

        subsets.sort(null);

        return subsets;
    }

    public static void main(String[] args) {
        List<String> subsets = new ArrayList<>();

//        generateSubset(subsets, new ArrayList<>(), "abc", 0);

//        generateSubset1(subsets, new StringBuilder(), "abc", 0);

//        Collections.sort(subsets);

//        System.out.println(subsets);

//        System.out.println(possibleSubsets("abc"));

        System.out.println(subsetsFindIt("abc"));
    }
}
