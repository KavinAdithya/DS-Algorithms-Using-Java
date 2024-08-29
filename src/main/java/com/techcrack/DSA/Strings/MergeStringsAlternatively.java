package com.techcrack.DSA.Strings;

class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder alternateWord = new StringBuilder();
        
        int word1Pointer = 0;
        int word2Pointer = 0;
        int length1 = word1.length();
        int length2 = word2.length();

        while (word1Pointer < length1 && word2Pointer < length2) {
            alternateWord.append(word1.charAt(word1Pointer));
            alternateWord.append(word2.charAt(word2Pointer));

            word1Pointer++;
            word2Pointer++;
        }

        while (word1Pointer < length1) {
            alternateWord.append(word1.charAt(word1Pointer));
            word1Pointer++;
        }
        
        while (word2Pointer < length2) {
            alternateWord.append(word2.charAt(word2Pointer));
            word2Pointer++;
        }

        return alternateWord.toString();
    }
}