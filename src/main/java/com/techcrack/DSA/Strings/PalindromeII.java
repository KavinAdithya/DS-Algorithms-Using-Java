package com.techcrack.DSA.Strings;

class PalindromeII {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, true) || isPalindrome(s, false);
    }

    public boolean isPalindrome(String s, boolean leftRemover) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        char[] sArray = s.toCharArray();
        boolean firstTime = true;

        while (leftPointer < rightPointer) {
            if (sArray[leftPointer] != sArray[rightPointer] && firstTime) {
                int result = leftRemover ? leftPointer++ : rightPointer--;
                firstTime = false;
                continue;
            }

            if (sArray[rightPointer] != sArray[leftPointer] && !firstTime)
                return false;
            
            leftPointer++;
            rightPointer--;
        }

        return true;
    }


    public boolean validPalindrome1(String s) {

        int leftPointer = 0;
        int rightPointer = s.length() - 1;


        while (leftPointer < rightPointer) {

            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                if (isPalindrome(s, leftPointer + 1, rightPointer))
                    return true;

                if (isPalindrome(s, leftPointer, rightPointer - 1))
                    return true;

                return false;
            }

            leftPointer++;
            rightPointer--;

        }

        return true;
    }

    public boolean isPalindrome(String s, int leftPointer, int rightPointer) {

        while (leftPointer < rightPointer) {

            if (s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;

            leftPointer++;
            rightPointer--;
        }

        return true;
    }


    public boolean checkPalindromeFormation(String a, String b) {

        return isSubstringPalindrome(a, b) || isSubstringPalindrome(b, a);
    }

    private boolean isSubstringPalindrome(String a, String b) {
        int aPointer = 0;

        int bPointer = b.length() - 1;

        while (aPointer < bPointer) {
            if (a.charAt(aPointer) != b.charAt(bPointer))
                break;
            aPointer++;
            bPointer--;
        }

        if (aPointer >= bPointer)
            return true;

        return isPalindrome1(a, aPointer, bPointer) || isPalindrome1(b, aPointer, bPointer);
    }

    private boolean isPalindrome1(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}