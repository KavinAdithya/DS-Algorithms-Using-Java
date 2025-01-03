package com.techcrack.DSA.strings;

class CountSubString {
    public long countSubstrings(String s, char c) {
        long occur = 0;

        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i))
                occur++;
        }

        return occur * (occur + 1) / 2;
    }
}