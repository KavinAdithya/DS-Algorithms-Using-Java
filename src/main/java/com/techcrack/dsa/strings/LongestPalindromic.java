package com.techcrack.dsa.strings;

class LongestPalindromic {
    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();

        int start = 0;
        int end = 0;

        for (int i = 0; i < sArray.length; i++) {
            for (int j = i + 1; j < sArray.length; j++) {
                if (isPalindrome(sArray, i, j) && j - i + 1 > end - start + 1) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(char[] sArray, int start, int end) {
        while (start < end) {
            if (sArray[start] != sArray[end])
                return false;
            start++;
            end--;
        }

        return true;
    }


    public String longestPalindrome1(String s) {
        int start = 0;
        int end = -1;

        char[] sArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left > -1 && right < s.length() && sArray[left] == sArray[right]) {
                if (right - left + 1 > end - start + 1) {
                    start = left;
                    end = right;

                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left > -1 && right < s.length() && sArray[left] == sArray[right]) {
                if (right - left + 1 > end - start + 1) {
                    start = left;
                    end = right;

                }
                left--;
                right++;
            }
        }

        return s.substring(start, end + 1);
    }
}