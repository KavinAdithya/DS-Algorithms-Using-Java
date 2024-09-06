package com.techcrack.DSA.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LexicographyOrder {
    public String lastSubstring1(String s) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++)
                substrings.add(s.substring(i, j + 1));
        }

        Collections.sort(substrings);

        return substrings.get(substrings.size() - 1);
    }


     public String lastSubstring2(String s) {
         int maximumIndex = -1;
         int previousAlphabet = -1;
         for (int i = 0; i < s.length(); i++) {
             int alphaOrder = s.charAt(i) - 'a';

             if (alphaOrder > previousAlphabet) {
                 previousAlphabet = alphaOrder;
                 maximumIndex = i;
             }
         }

         return s.substring(maximumIndex);
     }


    public String lastSubstring3(String s) {
        int maxIndex = -1;
        int maxAscii = -1;

        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';

            if (ascii > maxAscii) {
                maxAscii = ascii;
                maxIndex = i;
            }
        }

        List<String> substrings = new ArrayList<>();

        for (int i = maxIndex; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++)
                substrings.add(s.substring(i, j + 1));
        }

        Collections.sort(substrings);

        return substrings.get(substrings.size() - 1);
    }

    public String lastSubstring4(String s) {
        int i = 0;
        int j = 1;
        int length = s.length();
        char startCharacter = s.charAt(i);

        while (j < length) {
            if (startCharacter < s.charAt(j)) {
                i = j;
                startCharacter = s.charAt(j);
            }

            if (startCharacter == s.charAt(j)) {
                if (isMove(s, i, j)) {
                    i = j;
                    startCharacter = s.charAt(j);
                }
            }

            j++;
        }

        return s.substring(i, j);
    }


    private boolean isMove(String s, int i , int j) {

        while (i < j && j < s.length()) {
            if (s.charAt(i) > s.charAt(j))
                return false;
            if (s.charAt(i) < s.charAt(j))
                return true;
            i++;
            j++;
        }


        return i == j;
    }


    public String lastSubstring(String s) {
        int length = s.length() - 1;

        int maxIndex = length;
        for (int curIndex = length; curIndex > -1; curIndex--) {

            if (s.charAt(curIndex) > s.charAt(maxIndex))
                maxIndex = curIndex;
            else if (s.charAt(curIndex) == s.charAt(maxIndex)) {
                int i = curIndex + 1;
                int j = maxIndex + 1;

                while (i < maxIndex && j < length + 1 && s.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                }

                if (i == maxIndex || j == length + 1 || s.charAt(i) > s.charAt(j))
                    maxIndex = curIndex;
            }
        }

        return s.substring(maxIndex);
    }
}