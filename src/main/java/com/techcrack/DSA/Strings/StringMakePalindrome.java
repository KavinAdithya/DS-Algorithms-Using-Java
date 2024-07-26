package com.techcrack.DSA.Strings;

class StringMakePalindrome {
    public boolean checkPalindromeFormation1(String a, String b) {
        if (isPalindrome1(a) || isPalindrome1(b) || isDivideEqual1(a, b) || isDivideEqual1(b, a))
            return true;
        return false;       
    }

    // Changing the given string is palindrome or not using the two pointers
    public boolean isPalindrome1(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))   
                return false;
            start++;
            end--;
        }

        return true;
    }

    public StringBuilder partitionString1(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            sb.append(s.charAt(start));
            start++;
        }

        return sb;
    }

    public boolean isDivideEqual1(String s1, String s2) {
        int start = 0;
        int length = s1.length();
        int end = length - 1;

        while (start < end) {
            if (s1.charAt(start) != s2.charAt(end))
                break;
            start++;
            end--;
        }

        if (start >= end)
            return true;
        
        StringBuilder leftStart = partitionString1(s1, 0, start - 1);
        leftStart.append(partitionString1(s2, start, length - 1));

        StringBuilder rightStart = partitionString1(s1, 0, end);
        rightStart.append(partitionString1(s2, end + 1, length - 1));

        return isPalindrome1(leftStart.toString()) || isPalindrome1(rightStart.toString());

    }


    static class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return isDivideEqual(a, b) || isDivideEqual(b, a);
        }

        // Checking the given string is palindrome or not using the two pointers
        public boolean isPalindrome(String s, int start, int end) {


            while (start <= end) {
                if (s.charAt(start) != s.charAt(end))
                    return false;
                start++;
                end--;
            }

            return true;
        }
        public boolean isDivideEqual(String s1, String s2) {
            int start = 0;
            int length = s1.length();
            int end = length - 1;

            while (start < end) {
                if (s1.charAt(start) != s2.charAt(end))
                    break;
                start++;
                end--;
            }

            if (start >= end)
                return true;


            return isPalindrome(s1, start, end) || isPalindrome(s2, start, end);

        }
    }
}