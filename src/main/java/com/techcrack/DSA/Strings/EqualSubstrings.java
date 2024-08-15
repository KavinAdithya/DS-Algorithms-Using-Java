package com.techcrack.DSA.Strings;

class EqualSubstrings {
    public int equalSubstring(String s, String t, int maxCost) {
        int leftPointer = 0;
        int rightPointer = 0;

        int result = 0;
        int currentMaximum = 0;

        while (rightPointer < s.length()) {
            currentMaximum += Math.abs(s.charAt(rightPointer) - t.charAt(rightPointer));

            while ( currentMaximum > maxCost) {
                currentMaximum -= Math.abs(s.charAt(leftPointer) - t.charAt(leftPointer));
                leftPointer++;
            }

            result = Math.max(result, rightPointer - leftPointer + 1);
            rightPointer++;
        }

        return result;
    }
}