package com.techcrack.DSA.strings;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        char[] sArray = s.toCharArray();

        while (leftPointer < rightPointer) {
            char leftCharacter = Character.toLowerCase(sArray[leftPointer]);
            char rightCharacter = Character.toLowerCase(sArray[rightPointer]);

            if (! (Character.isDigit(leftCharacter) || (leftCharacter >= 'a' && leftCharacter <= 'z'))) {
                leftPointer++;
                continue;
            }

            if (! (Character.isDigit(rightCharacter) || (rightCharacter >= 'a' && rightCharacter <= 'z'))) {
                rightPointer--;
                continue;
            }

            if (leftCharacter != rightCharacter)
                return false;
            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}