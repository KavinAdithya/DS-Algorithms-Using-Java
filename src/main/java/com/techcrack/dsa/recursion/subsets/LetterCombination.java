package com.techcrack.dsa.recursion.subsets;

public class LetterCombination {
    static void letter(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        int digit = unprocessed.charAt(0) - '0';
        unprocessed = unprocessed.substring(1);

        int start = (digit - 2) * 3;

        start += (digit > 7 ? 1 : 0);

        int end = start + (digit == 7 || digit == 9 ? 4 : 3);


        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            letter(processed + ch, unprocessed);
        }
    }

    public static void main(String[] args) {
        letter("", "29");
    }
}
