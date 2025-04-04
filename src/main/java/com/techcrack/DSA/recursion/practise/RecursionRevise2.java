package com.techcrack.dsa.recursion.practise;

import java.util.*;

public class RecursionRevise2 {
    private static int count = 1;
    private static Set<String> subsets = new TreeSet<>();
    public static void subsets(String processed, String unprocessed, char prev) {
        if (unprocessed.isEmpty()) {
            if ( !processed.isEmpty()) {
                subsets.add(processed);
//                System.out.println(count + " " + processed);
                count++;
            }
            return;
        }

        char ch = unprocessed.charAt(0);
        String up = unprocessed.substring(1);

//        if (processed.isEmpty() || prev != ch || processed.charAt(processed.length() - 1) == ch)
            subsets(processed + ch, up, ch);
        subsets(processed, up, ch);
    }

    public static void subsetsIteration(String str) {
        List<String> subset = new ArrayList<>();
        subset.add("");

        for (int i = 0; i < str.length(); i++) {
            int size = subset.size();
            char ch = str.charAt(i);

            int start = 0;

            if (i > 0 && ch == str.charAt(i - 1)) {
                start = size / 2;
            }

            for (int j = start; j < size; j++) {
                String s = subset.get(j);
                subset.add(s + ch);
            }
        }

        Collections.sort(subset);

        System.out.println(subset + " \nLength : " + subset.size());
    }

//    private static boolean isNotContains(String processed, char ch) {
//        for (int i = 0; i < processed.length(); i++) {
//            if (processed.charAt(i) )
//        }
//    }


    public static void main(String[] args) {
        String unprocessed = "hello";
        subsets("", unprocessed, ' ');
        subsetsIteration (unprocessed);

//        Collections.sort(subsets);

        System.out.println(subsets + " \nLength : " + subsets.size());
    }
}
