package com.techcrack.dsa.recursion.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutation {
    static void stringPermutation(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char curChar = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);

        for (int i = 0; i < processed.length() + 1; i++) {
            String curProcess = processed.substring(0, i) + curChar + processed.substring(i);
            stringPermutation(curProcess, unprocessed);
        }
    }

    static int stringPermutationCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) return 1;

        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        int count = 0;

        for (int i = 0; i <= processed.length(); i++) {
            String curProcessed = processed.substring(0, i) + ch + processed.substring(i);

            count += stringPermutationCount(curProcessed, unprocessed);
        }

        return count;
    }

    static List<String> stringPermutationPersist(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return Collections.singletonList(processed);
        }

        char curChar = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < processed.length() + 1; i++) {
            String curProcess = processed.substring(0, i) + curChar + processed.substring(i);
            ans.addAll(stringPermutationPersist(curProcess, unprocessed));
        }

        return ans;
    }

    public static void main(String[] args) {
        String name = "abc";

        stringPermutation("", name);
//        System.out.println(name.substring(2) + " " + 'c');

//        System.out.println(stringPermutationPersist("", name));

        System.out.println(stringPermutationCount("", name));
    }
}
