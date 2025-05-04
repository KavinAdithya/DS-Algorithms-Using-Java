package com.techcrack.dsa.recursion.practise;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    private static final String[] DIGIT_LETTER_MAP = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public static void letComb(List<String> ans, char[] processed, String unprocessed, int index) {
        if (index == unprocessed.length()) {
            ans.add(new String(processed));
            return;
        }

        int digit = unprocessed.charAt(index) - '0';

        for (int i = 0; i < DIGIT_LETTER_MAP[digit].length(); i++) {
            processed[index] = DIGIT_LETTER_MAP[digit].charAt(i);

            letComb(ans, processed, unprocessed, index + 1);
        }
    }

    public static void letComb1(List<String> ans, char[] processed, String unprocessed, int index) {
        if (index == unprocessed.length()) {
            ans.add(new String(processed));
            return;
        }

        int digit = unprocessed.charAt(index) - '0';

        char start = (char)('a' + ((digit - 2) * 3));


        if (digit >= 8) {
            start++;
        }

        char end = (char) (start + 3);

        if (digit == 7 || digit == 9) {
            end++;
        }

        for (char i = start; i < end; i++) {
            processed[index] = i;

            letComb1(ans, processed, unprocessed, index + 1);
        }
    }

    public static void main(String[] args) {
        String unprocessed = "79";

        List<String> ans = new ArrayList<>();

        letComb1(ans, new char[unprocessed.length()], unprocessed, 0);

        System.out.println(ans);
    }
}
