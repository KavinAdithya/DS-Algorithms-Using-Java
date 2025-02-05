package com.techcrack.DSA.recursion.permutation;

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

    public static void main(String[] args) {
        String name = "abc";

        stringPermutation("", name);
//        System.out.println(name.substring(2) + " " + 'c');
    }
}
