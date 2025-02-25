package com.techcrack.dsa.algorithms;

public class KarpRabin {
    private static final int PRIME = 13;

    private static int hashValueForString(String str) {
        int hashValue = 0;

        for (int i = 0; i < str.length(); i++) {
            hashValue += ((str.charAt(i) - 'a' + 1) * (int) Math.pow(PRIME, i));
        }

        return hashValue;
    }

    private static int updateHashValue(char oldChar, char newChar, int hashValue, int m) {
        hashValue = (hashValue - (oldChar - 'a' + 1)) / PRIME;

        return hashValue + ((newChar - 'a' + 1) * (int)Math.pow(PRIME, m - 1));
    }

    private static void printSubstrings(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();

        int patternHash = hashValueForString(pattern);
        int textHash = hashValueForString(text.substring(0, m));

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (pattern.equals(text.substring(i, i + m)))
                    System.out.println(i + " " + (i + m - 1));
            }

            if (i + m < n)
                textHash = updateHashValue(text.charAt(i), text.charAt(i + m), textHash, m);

        }
    }

    public static void main(String[] args) {
        String pattern = "abc";
        String text = "dabcdabcdabcaabc";

        printSubstrings(pattern, text);
    }
}
